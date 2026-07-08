# cloud-itonami-isic-7220

Open Business Blueprint for **ISIC Rev.5 7220**: Research and
experimental development on social sciences and humanities.

This repository publishes a social-sciences-and-humanities-research
actor -- study intake, per-jurisdiction research-integrity regulatory
assessment, data-reproducibility-risk screening, human-subjects-
research-ethics-review screening and findings-report publication -- as
an OSS business that any qualified operator can fork, deploy, run,
improve and sell, so a community or independent research institute
never surrenders study data and ledgers to a closed SaaS.

Built on this workspace's
[`langgraph`](https://github.com/kotoba-lang/langgraph)
StateGraph runtime (portable `.cljc`, supervised superstep loop,
interrupts, Datomic/in-mem checkpoints) -- the same actor pattern as
every prior actor in this fleet
([`cloud-itonami-isic-6511`](https://github.com/cloud-itonami/cloud-itonami-isic-6511),
[`6512`](https://github.com/cloud-itonami/cloud-itonami-isic-6512),
[`6621`](https://github.com/cloud-itonami/cloud-itonami-isic-6621),
[`6622`](https://github.com/cloud-itonami/cloud-itonami-isic-6622),
[`6629`](https://github.com/cloud-itonami/cloud-itonami-isic-6629),
[`6520`](https://github.com/cloud-itonami/cloud-itonami-isic-6520),
[`6530`](https://github.com/cloud-itonami/cloud-itonami-isic-6530),
[`6820`](https://github.com/cloud-itonami/cloud-itonami-isic-6820),
[`6612`](https://github.com/cloud-itonami/cloud-itonami-isic-6612),
[`6492`](https://github.com/cloud-itonami/cloud-itonami-isic-6492),
[`6920`](https://github.com/cloud-itonami/cloud-itonami-isic-6920),
[`6611`](https://github.com/cloud-itonami/cloud-itonami-isic-6611),
[`7120`](https://github.com/cloud-itonami/cloud-itonami-isic-7120),
[`8620`](https://github.com/cloud-itonami/cloud-itonami-isic-8620),
[`8530`](https://github.com/cloud-itonami/cloud-itonami-isic-8530),
[`9200`](https://github.com/cloud-itonami/cloud-itonami-isic-9200),
[`7500`](https://github.com/cloud-itonami/cloud-itonami-isic-7500),
[`9603`](https://github.com/cloud-itonami/cloud-itonami-isic-9603),
[`9521`](https://github.com/cloud-itonami/cloud-itonami-isic-9521),
[`9321`](https://github.com/cloud-itonami/cloud-itonami-isic-9321),
[`8730`](https://github.com/cloud-itonami/cloud-itonami-isic-8730),
[`9102`](https://github.com/cloud-itonami/cloud-itonami-isic-9102),
[`9103`](https://github.com/cloud-itonami/cloud-itonami-isic-9103),
[`9602`](https://github.com/cloud-itonami/cloud-itonami-isic-9602),
[`9000`](https://github.com/cloud-itonami/cloud-itonami-isic-9000),
[`8890`](https://github.com/cloud-itonami/cloud-itonami-isic-8890),
[`8610`](https://github.com/cloud-itonami/cloud-itonami-isic-8610),
[`9311`](https://github.com/cloud-itonami/cloud-itonami-isic-9311),
[`8510`](https://github.com/cloud-itonami/cloud-itonami-isic-8510),
[`9412`](https://github.com/cloud-itonami/cloud-itonami-isic-9412),
[`6491`](https://github.com/cloud-itonami/cloud-itonami-isic-6491),
[`8720`](https://github.com/cloud-itonami/cloud-itonami-isic-8720),
[`8521`](https://github.com/cloud-itonami/cloud-itonami-isic-8521),
[`6619`](https://github.com/cloud-itonami/cloud-itonami-isic-6619),
[`3600`](https://github.com/cloud-itonami/cloud-itonami-isic-3600),
[`6190`](https://github.com/cloud-itonami/cloud-itonami-isic-6190),
[`3030`](https://github.com/cloud-itonami/cloud-itonami-isic-3030),
[`3830`](https://github.com/cloud-itonami/cloud-itonami-isic-3830),
[`7020`](https://github.com/cloud-itonami/cloud-itonami-isic-7020),
[`9420`](https://github.com/cloud-itonami/cloud-itonami-isic-9420),
[`9491`](https://github.com/cloud-itonami/cloud-itonami-isic-9491),
[`2610`](https://github.com/cloud-itonami/cloud-itonami-isic-2610),
[`3512`](https://github.com/cloud-itonami/cloud-itonami-isic-3512),
[`8810`](https://github.com/cloud-itonami/cloud-itonami-isic-8810),
[`8691`](https://github.com/cloud-itonami/cloud-itonami-isic-8691),
[`8569`](https://github.com/cloud-itonami/cloud-itonami-isic-8569),
[`6419`](https://github.com/cloud-itonami/cloud-itonami-isic-6419),
[`7310`](https://github.com/cloud-itonami/cloud-itonami-isic-7310),
[`7320`](https://github.com/cloud-itonami/cloud-itonami-isic-7320),
[`7210`](https://github.com/cloud-itonami/cloud-itonami-isic-7210),
[`7410`](https://github.com/cloud-itonami/cloud-itonami-isic-7410),
[`8710`](https://github.com/cloud-itonami/cloud-itonami-isic-8710),
[`8541`](https://github.com/cloud-itonami/cloud-itonami-isic-8541),
[`8690`](https://github.com/cloud-itonami/cloud-itonami-isic-8690),
[`9601`](https://github.com/cloud-itonami/cloud-itonami-isic-9601),
[`6420`](https://github.com/cloud-itonami/cloud-itonami-isic-6420),
[`7420`](https://github.com/cloud-itonami/cloud-itonami-isic-7420),
[`9609`](https://github.com/cloud-itonami/cloud-itonami-isic-9609),
[`8550`](https://github.com/cloud-itonami/cloud-itonami-isic-8550),
[`7010`](https://github.com/cloud-itonami/cloud-itonami-isic-7010),
[`8790`](https://github.com/cloud-itonami/cloud-itonami-isic-8790),
[`8542`](https://github.com/cloud-itonami/cloud-itonami-isic-8542),
[`6411`](https://github.com/cloud-itonami/cloud-itonami-isic-6411),
[`7490`](https://github.com/cloud-itonami/cloud-itonami-isic-7490),
[`9319`](https://github.com/cloud-itonami/cloud-itonami-isic-9319),
[`9329`](https://github.com/cloud-itonami/cloud-itonami-isic-9329),
[`9312`](https://github.com/cloud-itonami/cloud-itonami-isic-9312),
[`9492`](https://github.com/cloud-itonami/cloud-itonami-isic-9492),
[`9499`](https://github.com/cloud-itonami/cloud-itonami-isic-9499),
[`9512`](https://github.com/cloud-itonami/cloud-itonami-isic-9512),
[`9522`](https://github.com/cloud-itonami/cloud-itonami-isic-9522)) --
here it is **StudyOps-LLM ⊣ Research Integrity Governor** -- the SAME
governor name `research`/7210 (natural sciences and engineering)
already uses, a deliberate, honest reuse of the same research-
integrity-oversight business archetype for a different research
subject domain (see `docs/adr/0001-architecture.md` Decision 1 for why
this is not a naming error, and for why this is the THIRD confirmation
of the fleet-wide governor-name-reuse precedent, and the FIRST on a
governor-name family other than `:repair-shop-governor`).

> **Why an actor layer at all?** An LLM is great at drafting a study
> summary, normalizing records, and checking whether a study's own
> actual replication count actually reaches its own recorded minimum
> requirement -- but it has **no notion of which jurisdiction's
> research-integrity law is official, no license to publish a real
> findings report, and no way to know on its own whether a study
> involving human participants has actually cleared a real ethics-
> review board**. Letting it publish a findings report directly
> invites fabricated regulatory citations, an under-replicated study
> presented as validated, an unresolved data-reproducibility risk
> buried in the write-up, and a study on human subjects published
> without ever having cleared institutional review -- a real
> liability, for whoever runs it. This project seals the StudyOps-LLM
> into a single node and wraps it with an independent **Research
> Integrity Governor**, a human **approval workflow**, and an
> immutable **audit ledger**.

## Scope: what this actor does and does not do

This actor covers study intake through research-integrity regulatory
assessment, data-reproducibility-risk screening, human-subjects-
research-ethics-review screening and findings-report publication. It
does **not**, by itself, hold any license or institutional affiliation
required to operate a research lab in a given jurisdiction, and it
does not claim to. It also does not perform the actual research work
itself, or judge scholarly quality --
`socialresearch.registry/replication-count-insufficient?` is a pure
ground-truth comparison against the study's own recorded fields, not a
peer-review judgment. Whoever deploys and operates a live instance (a
qualified research operator/principal investigator) supplies any
jurisdiction-specific license/institutional affiliation, the real
research delivery and the real lab-notebook-system integrations, and
bears that jurisdiction's liability -- the software supplies the
governed, spec-cited, audited execution scaffold so that operator does
not have to build the compliance layer from scratch.

### Actuation

**Publishing a real findings report is never autonomous, at any
phase, by construction.** Two independent layers enforce this
(`socialresearch.governor`'s `:actuation/publish-findings-report`
high-stakes gate and `socialresearch.phase`'s phase table, which never
puts this op in any phase's `:auto` set) -- see
`socialresearch.phase`'s docstring and
`test/socialresearch/phase_test.clj`'s
`publish-findings-report-never-auto-at-any-phase`. The actor may
draft, check and recommend; a human research operator is always the
one who actually publishes a findings report. Grounded directly in
this blueprint's own README text ("No automated proposal, by itself,
can complete the following without governor approval and audit
evidence: publishing a findings report") -- a single-actuation shape
(one real-world act), matching `research`/7210's and every other
single-actuation sibling's own shape.

## The core contract

```
study intake + jurisdiction facts (socialresearch.facts, spec-cited)
        |
        v
   ┌───────────────────────┐   proposal      ┌───────────────────────┐
   │ StudyOps-LLM          │ ─────────────▶ │ Research Integrity            │  (independent system)
   │ (sealed)              │  + citations    │ Governor:                    │
   └───────────────────────┘                 │ spec-basis · evidence-       │
          │                 commit ◀┼ incomplete · replication-        │
          │                         │ count-insufficient (honest             │
    record + ledger        escalate ┼ reuse) · data-reproducibility-          │
          │              (ALWAYS for│ risk-unresolved (honest reuse) ·          │
          │       :actuation/publish-│ human-subjects-review-                    │
          │            -findings-    │ unconfirmed (conditional, NEW) ·          │
          │              report)     │ already-published                        │
          ▼                          └───────────────────────┘
      human approval
```

**The StudyOps-LLM never publishes a findings report the Research
Integrity Governor would reject, and never does so without a human
sign-off.** Hard violations (fabricated regulatory requirements;
unsupported evidence; an under-replicated study; an unresolved data-
reproducibility risk; an unconfirmed human-subjects-review for a study
that involves human subjects; a double publication) force **hold** and
*cannot* be approved past; a clean publication proposal still always
routes to a human.

## Run

```bash
clojure -M:dev:run     # walk one clean actuation lifecycle + five HARD-hold cases through the actor
clojure -M:dev:test    # governor contract · phase invariants · store parity · registry conformance · facts coverage
clojure -M:lint        # clj-kondo (errors fail; CI mirrors this)
```

## Robotics premise

All cloud-itonami verticals are designed on the premise that a **robot
performs the physical domain work**. Here a document-archive robot
manages physical survey/archival material custody, under the actor,
gated by the independent **Research Integrity Governor**. The governor
never dispatches hardware itself; `:high`/`:safety-critical` actions
require human sign-off.

## Open business

This repository is not only source code. It is a public, forkable
business model:

| Layer | What is open |
|---|---|
| OSS core | Actor runtime, Research Integrity Governor, findings-report draft records, audit ledger |
| Business blueprint | Customer, offer, pricing, unit economics, sales motion |
| Operator playbook | How to fork, license, deploy and support the service in a jurisdiction |
| Trust controls | Governance, security reporting, actuation invariant, audit requirements |

See [`docs/business-model.md`](docs/business-model.md) and
[`docs/operator-guide.md`](docs/operator-guide.md) to start this as an
open business on itonami.cloud, and
[`docs/adr/0001-architecture.md`](docs/adr/0001-architecture.md) for the
full architecture and decision record.

## Capability layer

This blueprint resolves its technology stack via
[`kotoba-lang/industry`](https://github.com/kotoba-lang/industry) (ISIC
`7220`). This vertical's engagement records are practice-specific
rather than a shared cross-operator data contract, so
`socialresearch.*` runs on the generic robotics/identity/forms/dmn/
bpmn/audit-ledger stack only -- no bespoke domain capability lib to
reference at all.

## Layout

| File | Role |
|---|---|
| `src/socialresearch/store.cljc` | **Store** protocol -- `MemStore` ‖ `DatomicStore` (`langchain.db`) + append-only audit ledger + findings-report history. The double-actuation guard checks a dedicated `:findings-report-published?` boolean rather than a `:status` value |
| `src/socialresearch/registry.cljc` | Findings-report draft records, plus `replication-count-insufficient?` -- an HONEST, literal reuse of `research.registry`'s own SEVENTH-instance MINIMUM-threshold sufficiency check, not claimed as new |
| `src/socialresearch/facts.cljc` | Per-jurisdiction research-integrity catalog AND a SEPARATE human-subjects-research-ethics-review citation per jurisdiction (a genuine extension beyond `research.facts`'s own general-research-misconduct-only catalog) with an official spec-basis citation per entry, honest coverage reporting |
| `src/socialresearch/studyopsllm.cljc` | **StudyOps-LLM** -- `mock-advisor` ‖ `llm-advisor`; intake/protocol-verification/data-reproducibility-risk-screening/human-subjects-review-screening/findings-report-publication proposals |
| `src/socialresearch/governor.cljc` | **Research Integrity Governor** -- 5 HARD checks (spec-basis · evidence-incomplete · replication-count-insufficient, honest reuse · data-reproducibility-risk-unresolved, honest reuse · human-subjects-review-unconfirmed, conditional unconditional-evaluation, GENUINELY NEW, the 63rd grounding of this discipline) + 1 guard (already-published) + 1 soft (confidence/actuation gate) |
| `src/socialresearch/phase.cljc` | **Phase 0→3** -- read-only → assisted intake → assisted verify → supervised (findings-report publication always human; study intake is the ONLY auto-eligible op, no direct capital risk) |
| `src/socialresearch/operation.cljc` | **OperationActor** -- langgraph StateGraph |
| `src/socialresearch/sim.cljc` | demo driver |
| `test/socialresearch/*_test.clj` | governor contract · phase invariants · store parity · registry conformance · facts coverage |

## Business-process coverage (honest)

This actor covers study intake through research-integrity regulatory
assessment, data-reproducibility-risk screening, human-subjects-
research-ethics-review screening and findings-report publication --
the core governed lifecycle this blueprint's own
`docs/business-model.md` names as its Offer:

| Covered | Not covered (out of scope for this R0) |
|---|---|
| Study intake + per-jurisdiction evidence checklisting, HARD-gated on an official spec-basis citation (`:study/intake`/`:protocol/verify`) | Real lab-notebook-system integration, real research work itself (see `socialresearch.facts`'s docstring) |
| Data-reproducibility-risk screening + human-subjects-research-ethics-review screening, each evaluated unconditionally (the latter conditional on the study's own `:involves-human-subjects?` ground truth) so the screening op itself can HARD-hold on its own finding (`:risk/screen`/`:ethics/screen`) | Scholarly-quality/peer-review judgment itself -- deliberately outside this actor's competence |
| Findings-report publication, HARD-gated on full evidence, replication-count sufficiency, resolved data-reproducibility risk and confirmed human-subjects-review (when applicable), plus a double-publication guard (`:actuation/publish-findings-report`) | |
| Immutable audit ledger for every intake/verification/screening/publication decision | |

Extending coverage is additive: add the next gate (e.g. a funding-
disclosure-verification check) as its own governed op with its own
HARD checks and tests, following the SAME "an independent governor
re-verifies against the actor's own records before any real-world act"
pattern this repo's flagship ops already establish.

## Jurisdiction coverage (honest)

`socialresearch.facts/coverage` reports how many requested
jurisdictions actually have an official spec-basis in
`socialresearch.facts/catalog` -- currently 4 seeded (JPN, USA, GBR,
DEU) out of ~194 jurisdictions worldwide. This is a starting catalog
to prove the governor contract end-to-end, not a claim of global
coverage. Adding a jurisdiction is additive: one map entry in
`socialresearch.facts/catalog`, citing a real official source -- never
fabricate a jurisdiction's requirements to make coverage look bigger.

## Maturity

`:implemented` -- `StudyOps-LLM` + `Research Integrity Governor` run
as real, tested code (see `Run` above), promoted from the originally-
published `:blueprint`-tier scaffold, modeled closely on `research`/
7210's own architecture and the seventy-seven other prior actors'
architecture across this fleet. See
`docs/adr/0001-architecture.md` for the history and design.

## License

Code and implementation templates are AGPL-3.0-or-later.
