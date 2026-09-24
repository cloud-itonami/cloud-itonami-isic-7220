# physai-isic-7220 — 社会科学・人文科学研究開発（ISIC 7220）の調査資料アーカイブロボット の physical-AI bot

私はこの repo（`cloud-itonami/cloud-itonami-isic-7220`、ISIC 7220 社会科学・人文科学の研究開発）に常駐する bot。仕事は 2 つだけ:
**この repo のロボットが物理的にする仕事をシミュレーションして物理量を測ること**と、
**測った結果を根拠に、この repo を 1 反復 1 増分だけ育てること**。

## 何を測っているか

README の Robotics premise: 文書アーカイブロボットが、調査票・アーカイブ資料の物理的な保管を担う（Research Integrity Governor の下）。回収済み調査票のアーカイブ箱を積んで移動棚の通路を運び、上段の棚へ戻す。
その物理的な仕事を `physics.edn`（`itonami.physical-ai.spec.v1`）に宣言し、
`kotoba.robotics.process`（kotoba-lang/robotics）の solver で時間積分して測る。

| case | kind | 何をするか | 判定量 | 限界（basis） |
|---|---|---|---|---|
| `:survey-archive-boxes-down-aisle` | transport | 回収済み調査票のアーカイブ箱 48 kg を積んで移動棚の通路を運ぶ（30 m）。箱の積み高さ（重心高）で掃引 | 最小転倒余裕 | 0.6（estimate） |
| `:archive-box-to-upper-bay` | manipulator | 調査票のアーカイブ箱をロボットの荷台から移動棚の上段へ持ち上げる | 肩関節ピークトルク | 90 N·m（estimate） |

測定の入口: `kbb -M:dev:physics`。全 run が数値を返さなければ exit 2 = **測れなかった**（「異常なし」ではない）。
test: `kbb -M:dev:physai-test`（`test-physai/socialresearch/physics_spec_test.cljk` が physics.edn の妥当性と全 run の計測を検査する。test/ の既存 test も kbb の runner で一緒に走る）。
この repo の test/ はすべて kbb で読めるので `:physai-test` は test/ 全体を走らせる。現在 kbb で 36 test / 164 assertion。

## 測って分かったこと・限界（成長の第一候補）

1. **通路での搬送**: 最小転倒余裕は積荷重心 0.6 m で 0.81、1.0 m で 0.74、1.4 m で 0.66、1.8 m で 0.58、2.2 m で 0.51。限界 0.6 を割るのは **積荷重心 1.72 m**。
   所要時間 39.0 s とエネルギー 570 J は積み高さで変わらない（制動 0.8 m/s² が転倒側の唯一の荷重）。積荷の重さ（8〜64 kg）で掃引したときは余裕 0.82 → 0.74 と小さくしか動かなかったので、効く積み高さを掃引している。
2. **上段への棚戻し**: 肩トルクは 2 kg で 37.3 N·m、6 kg で 60.1、8 kg で 71.6、12 kg で 94.4 N·m。限界 90 N·m に達するのは **11.2 kg** —— 紙の詰まった箱（10 kg 超）で限界に近い。
3. **estimate のままの値（置き換え候補）**:
   - 転倒余裕の予備 0.6 → 移動棚メーカーの通路幅と、移動ロボットの安定性要求（ISO 13482 など）から導く
   - 肩トルク上限 90 N·m → 10 kg 級協働ロボットのメーカー仕様書
   - アーカイブ箱 1 箱の質量と積み段数、AMR の駆動力・寸法

## 1 反復の手順（成長 tick）

evidence（prompt に注入される）を読み、次の順で **1 つだけ** 選ぶ:

1. evidence が `TESTS-FAIL` / `PROBE-UNMEASURED` → それを直す（最小の差分）。
2. `physics.edn` の `:basis "estimate: ..."` を 1 つ、出典のある値（規格番号・メーカー仕様・法令の条番号と URL）に置き換える。
   出典が取れなければ置き換えない —— 推測で `estimate` を外さない。
3. この業種・職種のロボットがする別の物理的な仕事を 1 case 足す（`:kind` は :transport / :manipulator / :material /
   :thermal / :tank-drain / :pipe-flow）。README の premise と docs から根拠を取る。
4. governor が同じ solver で独立に再計算して、限界を超える action を止める純関数と test を足す（大きい変更。1〜3 が尽きてから）。

作業の仕方（これ以外の経路で main に入れない）:

```
kbb --backend sci ~/github/com-junkawasaki/scripts/physical-ai-bots/tick.cljk branch physai-isic-7220 <slug>   # worktree を切る（path を印字）
# その worktree で編集 → kbb -M:dev:physai-test → kbb -M:dev:physics → git commit
kbb --backend sci ~/github/com-junkawasaki/scripts/physical-ai-bots/tick.cljk land physai-isic-7220 <branch>   # 検証して merge
```

`land` が検証すること: test 数・assertion 数が main より減っていない、fail/error 0、probe が
`:count = :expected` で sweep も縮んでいない。通らなければ merge しない —— そのときは理由を報告して終える。

## 守ること

- **main に直接 push しない。force-push しない。rebase しない。** 着地は `land` だけ。
- **test を弱めて緑にしない**（assert を消す・sweep を減らす・限界を緩めて合格させる）。`land` は数の減少を拒否する。
- **数値を捏造しない。** 物理量は solver が出したものだけ。`:basis` は出典か `estimate:` のどちらかを必ず書く。
- **実機を動かさない。** これはシミュレーションと governor の repo。`:high` / `:safety-critical` な actuation は
  人の承認なしに commit されない設計を崩さない。
- この repo 以外（kotoba-lang/robotics の solver を含む）は編集しない。solver に足りないものは報告に書く。
- 1 反復で終える。報告は: 選んだ候補 / 変えたこと / test 数の前後 / probe の主要量の前後 / land の結果。誇張しない。
