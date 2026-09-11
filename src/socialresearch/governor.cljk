(ns socialresearch.governor
  "Research Integrity Governor -- the independent compliance layer
  that earns the StudyOps-LLM the right to commit. The LLM has no
  notion of research-integrity/good-scientific-practice law, whether a
  study's own actual replication count actually reaches its own
  recorded minimum requirement, whether a data-reproducibility risk or
  a human-subjects-review confirmation against a study has actually
  been resolved, or when an act stops being a draft and becomes a
  real-world findings-report publication, so this MUST be a separate
  system able to *reject* a proposal and fall back to HOLD -- the
  social-sciences-and-humanities-lab analog of `cloud-itonami-isic-
  7210`'s ResearchIntegrityGovernor.

  This is the THIRD confirmation of the fleet-wide governor-name-reuse
  precedent `commrepair`/9512's own ADR-0001 established (1st:
  commrepair/9512 sharing `:repair-shop-governor` with repairshop/9521;
  2nd: applianceshop/9522 sharing the SAME name a second time) -- and
  the FIRST confirmation on a DIFFERENT governor-name family
  (`:research-integrity-governor`, shared with `research`/7210 rather
  than `:repair-shop-governor`), demonstrating the precedent
  generalizes across independent governor-name collisions, not just
  within one cluster. Sharing this governor name is honest: both
  actors are research-integrity oversight of an R&D lab publishing
  findings reports, differing only in subject domain (natural sciences/
  engineering vs. social sciences/humanities) -- see this repo's own
  `docs/adr/0001-architecture.md` Decision 1.

  Six checks, in priority order, ALL HARD violations except the
  confidence/actuation gate: a human approver CANNOT override them
  (you don't get to approve your way past a fabricated jurisdiction
  spec-basis, incomplete evidence, an under-replicated study, an
  unresolved data-reproducibility risk, or an unconfirmed human-
  subjects-review). The confidence/actuation gate is SOFT: it asks a
  human to look (low confidence / actuation), and the human may
  approve -- but see `socialresearch.phase`: for `:stake :actuation/
  publish-findings-report` (a real publication/submission act) NO
  phase ever allows auto-commit either. Two independent layers agree
  that actuation is always a human call.

    1. Spec-basis                  -- did the protocol proposal cite
                                       an OFFICIAL source
                                       (`socialresearch.facts`), or
                                       invent one?
    2. Evidence incomplete         -- for `:actuation/publish-
                                       findings-report`, has the study
                                       actually been assessed with a
                                       full study-protocol-record/
                                       data-collection-record/
                                       methodology-citation-record/
                                       replication-record evidence
                                       checklist on file?
    3. Replication count
       insufficient                   -- for `:actuation/publish-
                                       findings-report`, INDEPENDENTLY
                                       recompute whether the study's
                                       own actual replication count
                                       falls short of its own recorded
                                       minimum-required replication
                                       count (`socialresearch.registry/
                                       replication-count-
                                       insufficient?`) -- an HONEST,
                                       LITERAL reuse of `research.
                                       registry`'s own SEVENTH-instance
                                       MINIMUM-threshold sufficiency
                                       check, NOT claimed as new (see
                                       that ns's docstring).
    4. Data-reproducibility risk
       unresolved                     -- reported by THIS proposal
                                       itself (a `:risk/screen` that
                                       just found one), or already on
                                       file for the study (`:risk/
                                       screen`/`:actuation/publish-
                                       findings-report`). An HONEST,
                                       LITERAL reuse of `research.
                                       governor`'s own FORTIETH-instance
                                       unconditional-evaluation
                                       grounding, NOT claimed as new.
    5. Human-subjects-review
       unconfirmed                    -- for a study whose own record
                                       declares `:involves-human-
                                       subjects? true` (surveys,
                                       interviews, focus groups,
                                       ethnographic fieldwork --
                                       characteristic of social-
                                       science research and essentially
                                       ABSENT from `research`/7210's
                                       own natural-science/engineering
                                       concerns), INDEPENDENTLY check
                                       whether `:human-subjects-review-
                                       confirmed?` is true
                                       (`socialresearch.registry`
                                       carries no such check itself --
                                       this is a direct ground-truth
                                       boolean read, deliberately NOT
                                       gated through a registry pure-
                                       function the way replication-
                                       count is, since it needs no
                                       arithmetic). A GENUINELY NEW
                                       concept (grep-verified absent
                                       fleet-wide before this claim was
                                       finalized -- 'irb'/'human-
                                       subject'/'research-ethics'/
                                       'informed-consent'/'ethics-
                                       review'/'ethics-committee'
                                       returned zero hits), grounded in
                                       real human-subjects-research-
                                       ethics-review law: US 45 C.F.R.
                                       Part 46 (the Common Rule, OHRP),
                                       UK ESRC Framework for Research
                                       Ethics, Germany's DFG Leitlinie
                                       13 (Ethikkommissionen), Japan's
                                       人を対象とする生命科学・医学系研究に関する倫理指針
                                       (MEXT/MHLW/METI). CONDITIONAL on
                                       `:involves-human-subjects?` --
                                       unlike the unconditional checks
                                       above, a study that does NOT
                                       involve human subjects (e.g.
                                       pure archival/textual-corpus
                                       analysis) has no ethics-review
                                       requirement at all; forcing one
                                       onto every study regardless of
                                       whether it actually touches
                                       human participants would be a
                                       fabricated requirement, the same
                                       failure mode `socialresearch.
                                       facts` refuses to commit for an
                                       uncataloged jurisdiction. This is
                                       the SIXTY-THIRD distinct
                                       application of the
                                       unconditional-evaluation-
                                       DISCIPLINE overall (`casualty.
                                       governor/sanctions-violations`'s
                                       original fix; most recently
                                       `applianceshop.governor/
                                       refrigerant-handling-
                                       certification-unconfirmed-
                                       violations` at 62nd) -- reading a
                                       dedicated ground-truth fact off
                                       the entity rather than trusting
                                       the advisor's self-report, even
                                       though its ACTIVATION is scoped
                                       by another ground-truth fact on
                                       the same entity.
    6. Confidence floor / actuation
       gate                          -- LLM confidence below threshold,
                                       OR the op is `:actuation/
                                       publish-findings-report` (a REAL
                                       publication/submission act) ->
                                       escalate.

  One more guard, double-publication prevention, is enforced but NOT
  listed as a numbered HARD check above because it needs no upstream
  comparison at all -- `already-published-violations` refuses to
  publish a findings report for the SAME study twice, off a dedicated
  `:findings-report-published?` fact (never a `:status` value) -- an
  honest, literal reuse of `research.governor`'s own guard, informed by
  `cloud-itonami-isic-6492`'s status-lifecycle bug (ADR-2607071320)."
  (:require [socialresearch.facts :as facts]
            [socialresearch.registry :as registry]
            [socialresearch.store :as store]))

(def confidence-floor 0.6)

(def high-stakes
  "Stakes grave enough to always require a human, even when clean.
  Publishing/submitting a real findings report is the ONE real-world
  actuation event this actor performs -- a single-member set, matching
  `research`'s (and every prior single-actuation sibling's) shape,
  grounded directly in this blueprint's own README ('No automated
  proposal, by itself, can complete the following without governor
  approval and audit evidence: publishing a findings report')."
  #{:actuation/publish-findings-report})

;; ----------------------------- checks -----------------------------

(defn- spec-basis-violations
  "A `:protocol/verify` (or `:actuation/publish-findings-report`)
  proposal with no spec-basis citation is a HARD violation -- never
  invent a jurisdiction's research-integrity requirements."
  [{:keys [op]} proposal]
  (when (contains? #{:protocol/verify :actuation/publish-findings-report} op)
    (let [value (:value proposal)]
      (when (or (empty? (:cites proposal))
                (and (contains? value :spec-basis) (nil? (:spec-basis value))))
        [{:rule :no-spec-basis
          :detail "公式spec-basisの引用が無い提案は研究公正性基準として扱えない"}]))))

(defn- evidence-incomplete-violations
  "For `:actuation/publish-findings-report`, the jurisdiction's
  required study-protocol-record/data-collection-record/methodology-
  citation-record/replication-record evidence must actually be
  satisfied -- do not trust the advisor's self-reported confidence
  alone."
  [{:keys [op subject]} st]
  (when (= op :actuation/publish-findings-report)
    (let [s (store/study st subject)
          protocol (store/protocol-of st subject)]
      (when-not (and protocol
                     (facts/required-evidence-satisfied?
                      (:jurisdiction s) (:checklist protocol)))
        [{:rule :evidence-incomplete
          :detail "法域の必要書類(研究計画記録/データ収集記録/方法論引用記録/再現実験記録等)が充足していない状態での提案"}]))))

(defn- replication-count-insufficient-violations
  "For `:actuation/publish-findings-report`, INDEPENDENTLY recompute
  whether the study's own actual replication count falls short of its
  own recorded minimum-required replication count via `socialresearch.
  registry/replication-count-insufficient?` -- an HONEST, LITERAL
  reuse of `research.governor`'s own check, NOT claimed as new."
  [{:keys [op subject]} st]
  (when (= op :actuation/publish-findings-report)
    (let [s (store/study st subject)]
      (when (registry/replication-count-insufficient? s)
        [{:rule :replication-count-insufficient
          :detail (str subject " の実再現回数(" (:actual-replication-count s)
                      ")が必要最小再現回数(" (:minimum-required-replication-count s) ")を下回る")}]))))

(defn- data-reproducibility-risk-unresolved-violations
  "An unresolved data-reproducibility risk -- reported by THIS
  proposal (e.g. a `:risk/screen` that itself just found one), or
  already on file in the store for the study (`:risk/screen`/
  `:actuation/publish-findings-report`) -- is a HARD, un-overridable
  hold. An HONEST, LITERAL reuse of `research.governor`'s own check,
  NOT claimed as new."
  [{:keys [op subject]} proposal st]
  (let [hit-in-proposal? (= :unresolved (get-in proposal [:value :verdict]))
        study-id (when (contains? #{:risk/screen :actuation/publish-findings-report} op) subject)
        hit-on-file? (and study-id (= :unresolved (:verdict (store/risk-screen-of st study-id))))]
    (when (or hit-in-proposal? hit-on-file?)
      [{:rule :data-reproducibility-risk-unresolved
        :detail "未解決のデータ再現性リスクがある研究の報告書公開提案は進められない"}])))

(defn- human-subjects-review-unconfirmed-violations
  "For a study that itself declares `:involves-human-subjects? true`,
  INDEPENDENTLY check whether `:human-subjects-review-confirmed?` is
  true -- a genuinely new concept (see ns docstring), CONDITIONAL on
  the study's own `:involves-human-subjects?` ground truth (a study
  that does not involve human subjects has no ethics-review
  requirement at all). Scoped to `:ethics/screen` and `:actuation/
  publish-findings-report`, so the screening op itself can HARD-hold
  on its own finding, matching every prior unconditional-evaluation
  check's scoping shape."
  [{:keys [op subject]} st]
  (when (contains? #{:ethics/screen :actuation/publish-findings-report} op)
    (let [s (store/study st subject)]
      (when (and (true? (:involves-human-subjects? s))
                 (not (true? (:human-subjects-review-confirmed? s))))
        [{:rule :human-subjects-review-unconfirmed
          :detail (str subject " は人を対象とする研究だが倫理審査(IRB/倫理委員会)承認が未確認 -- 報告書公開提案は進められない")}]))))

(defn- already-published-violations
  "For `:actuation/publish-findings-report`, refuses to publish a
  findings report for the SAME study twice, off a dedicated
  `:findings-report-published?` fact (never a `:status` value). An
  honest, literal reuse of `research.governor`'s own guard."
  [{:keys [op subject]} st]
  (when (= op :actuation/publish-findings-report)
    (when (store/study-already-published? st subject)
      [{:rule :already-published
        :detail (str subject " は既に報告書公開済み")}])))

(defn check
  "Censors a StudyOps-LLM proposal against the governor rules. Returns
  {:ok? bool :violations [..] :confidence c :escalate? bool
  :high-stakes? bool :hard? bool}."
  [request _context proposal st]
  (let [hard (into []
                   (concat (spec-basis-violations request proposal)
                           (evidence-incomplete-violations request st)
                           (replication-count-insufficient-violations request st)
                           (data-reproducibility-risk-unresolved-violations request proposal st)
                           (human-subjects-review-unconfirmed-violations request st)
                           (already-published-violations request st)))
        conf (:confidence proposal 0.0)
        low? (< conf confidence-floor)
        stakes? (boolean (high-stakes (:stake proposal)))
        hard? (boolean (seq hard))]
    {:ok?          (and (not hard?) (not low?) (not stakes?))
     :violations   hard
     :confidence   conf
     :hard?        hard?
     :escalate?    (and (not hard?) (or low? stakes?))
     :high-stakes? stakes?}))

(defn hold-fact
  "The audit fact written when a proposal is rejected (HOLD)."
  [request context verdict]
  {:t          :governor-hold
   :op         (:op request)
   :actor      (:actor-id context)
   :subject    (:subject request)
   :disposition :hold
   :basis      (mapv :rule (:violations verdict))
   :violations (:violations verdict)
   :confidence (:confidence verdict)})
