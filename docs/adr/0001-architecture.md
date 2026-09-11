# ADR-0001: StudyOps-LLM ⊣ Research Integrity Governor architecture

## Status

Accepted. `cloud-itonami-isic-7220` promoted from `:blueprint` to
`:implemented` in the `kotoba-lang/industry` registry.

## Context

`cloud-itonami-isic-7220` publishes an OSS business blueprint for
research and experimental development on social sciences and
humanities: systematic study to increase knowledge of society,
behavior, culture and history. Like every prior actor in this fleet,
the blueprint alone is not an implementation: this ADR records the
governed-actor architecture that promotes it to real, tested code,
following the same langgraph StateGraph + independent Governor +
Phase 0→3 rollout pattern established by `cloud-itonami-isic-6511`
(life insurance) and applied across seventy-seven prior siblings, most
recently `cloud-itonami-isic-9522` (repair of household appliances).

This blueprint's own `:itonami.blueprint/governor` keyword,
`:research-integrity-governor`, is IDENTICAL to `research`/7210's
(research and experimental development on natural sciences and
engineering). Before this build, the fleet-wide governor-name-
collision survey (`sportsclub`/9312's methodology) had flagged this as
a hard blocker. `commrepair`/9512's own ADR-0001 established that the
collision constraint was never a structural requirement -- sharing a
governor name is acceptable when the underlying business archetype is
genuinely the same, provided the reuse is documented and the new build
brings its own genuinely differentiated, well-grounded check. That
precedent was confirmed a second time by `applianceshop`/9522 (within
the SAME `:repair-shop-governor` cluster). This build is the THIRD
confirmation overall, and the FIRST on a DIFFERENT governor-name
family (`:research-integrity-governor` rather than `:repair-shop-
governor`), demonstrating the precedent generalizes across independent
governor-name collisions, not just within one cluster.

## Decision

### Decision 1: governor-name reuse -- the third confirmation, first on a new family

`research`/7210 and `socialresearch`/7220 both perform research-
integrity oversight of an R&D lab publishing findings reports,
differing only in subject domain (natural sciences/engineering vs.
social sciences/humanities). Reusing `:research-integrity-governor` is
an honest reflection of that shared archetype, not a naming error --
the same reasoning `commrepair`/9512's and `applianceshop`/9522's own
ADR-0001s applied to `:repair-shop-governor`. This build's own
genuinely differentiated concern (Decision 5 below) demonstrates the
precedent is not limited to the repair-shop cluster.

### Decision 2: single-actuation shape

This blueprint's own README, business-model.md and operator-guide.md
consistently name only ONE real-world act: "publishing a findings
report." Matching `research`/7210's (and every other single-actuation
sibling's) shape, `high-stakes` here is a one-member set,
`#{:actuation/publish-findings-report}`.

### Decision 3: entity and op shape

The primary entity is a `study`. Five ops: `:study/intake` (directory
upsert, no capital risk), `:protocol/verify` (per-jurisdiction
research-integrity evidence checklist, never auto), `:risk/screen`
(data-reproducibility-risk screening, honest reuse of `research`/
7210's own unconditional-evaluation discipline, never auto),
`:ethics/screen` (human-subjects-research-ethics-review screening,
GENUINELY NEW, never auto), and `:actuation/publish-findings-report`
(POSITIVE, high-stakes -- publishing a real findings report).

### Decision 4: `replication-count-insufficient?` and `data-reproducibility-risk-unresolved?` -- honest, literal reuses

`socialresearch.registry/replication-count-insufficient?` and
`socialresearch.governor/data-reproducibility-risk-unresolved-
violations` are HONEST, LITERAL reuses of `research.registry`'s and
`research.governor`'s own checks (the SEVENTH MINIMUM-threshold
sufficiency instance and the FORTIETH unconditional-evaluation
grounding, respectively) -- NOT claimed as new. Quantitative social-
science research (surveys redone across independent samples,
experimental/quasi-experimental designs) has the SAME replication and
data-reproducibility concerns as natural-science/engineering
experiments; reusing the checks unchanged is the honest choice, the
same discipline `applianceshop`/9522's own reuse of `parts-cost-
matches-claim?`/`safety-test-not-passed` established.

### Decision 5: `human-subjects-review-unconfirmed?` -- the 63rd unconditional-evaluation grounding, a genuinely new concept, CONDITIONAL on the study's own ground truth

Before writing this check, every prior sibling's governor/registry/
store namespaces across the entire fleet were grepped for `irb`,
`human-subject`, `research-ethics`, `informed-consent`, `ethics-
review` and `ethics-committee` -- zero hits, confirming this is a
genuinely new concept. `human-subjects-review-unconfirmed-violations`
reuses the unconditional-evaluation-screening DISCIPLINE (`casualty.
governor/sanctions-violations`'s original fix) for the 63rd distinct
application overall (most recently `applianceshop.governor/
refrigerant-handling-certification-unconfirmed-violations` at 62nd).
Unlike most prior instances, this check is deliberately CONDITIONAL:
it only activates when the study's own record declares
`:involves-human-subjects? true`. A study that does not involve human
subjects (e.g. pure archival/textual-corpus analysis) has no ethics-
review requirement at all -- forcing one onto every study regardless
of whether it actually touches human participants would itself be a
fabricated requirement, the same failure mode `socialresearch.facts`
refuses to commit for an uncataloged jurisdiction. Grounded in real
human-subjects-research-ethics-review law: US 45 C.F.R. Part 46 (the
Common Rule, OHRP), UK ESRC Framework for Research Ethics, Germany's
DFG Leitlinie 13 (Ethikkommissionen), Japan's
人を対象とする生命科学・医学系研究に関する倫理指針 (MEXT/MHLW/METI). Gates
`:ethics/screen` and `:actuation/publish-findings-report`.

### Decision 6: dedicated double-actuation-guard boolean

`:findings-report-published?` is a dedicated boolean on the `study`
record, never a single `:status` value -- an honest, literal reuse of
`research.governor`'s own guard, informed by `cloud-itonami-isic-
6492`'s real status-lifecycle bug (ADR-2607071320).

### Decision 7: Store protocol, MemStore + DatomicStore parity

`socialresearch.store/Store` is implemented by both `MemStore` (atom-
backed, default for dev/tests/demo) and `DatomicStore` (`langchain.
db`-backed), proven to satisfy the same contract in
`test/socialresearch/store_contract_test.cljk` -- the same seam every
sibling actor uses so swapping the SSoT backend is a configuration
change, not a rewrite.

### Decision 8: Phase 0→3 rollout

Phase 3's `:auto` set has exactly one member, `:study/intake` (no
capital risk). `:protocol/verify`, `:risk/screen` and `:ethics/screen`
are never auto-eligible at any phase (matching every sibling's
screening-op posture), and `:actuation/publish-findings-report` is
permanently excluded from every phase's `:auto` set -- a structural
fact, not a rollout milestone, enforced by BOTH `socialresearch.phase`
and `socialresearch.governor`'s `high-stakes` set independently.

### Decision 9: no bespoke domain capability lib

This blueprint's own `:itonami.blueprint/required-technologies` names
no domain-specific capability beyond the generic robotics/identity/
forms/dmn/bpmn/audit-ledger stack (unlike `research`/7210's own
`:cae`) -- there was no capability-lib decision to make at all.

### Decision 10: mock + LLM advisor pair, and no `blueprint.edn` field-sync fixes needed

`socialresearch.studyopsllm` provides `mock-advisor` (deterministic,
default everywhere) and `llm-advisor` (backed by `langchain.model/
ChatModel`, with a defensive EDN-proposal parser). Matching
`research`/7210's, `advertising`/7310's and `polling`/7320's own
experience, this repo's `blueprint.edn` already had the correct
`isic-` prefixed `:id` and correctly populated `:required-
technologies`/`:optional-technologies` matching the `kotoba-lang/
industry` registry's own entry for `"7220"` exactly -- only the
`:maturity` field itself needed adding.

## Alternatives considered

- **Declining the build and leaving 7220 blocked**, treating the
  original governor-name-collision survey as final. Rejected:
  `commrepair`/9512's and `applianceshop`/9522's own ADR-0001s already
  established that the collision constraint was a self-imposed
  convention, not a structural requirement, WITHIN the repair-shop
  cluster; reapplying that reasoning to a DIFFERENT governor-name
  family here confirms it generalizes rather than being limited to one
  cluster.
- **An unconditional human-subjects-review check** (applying to every
  study regardless of subject matter). Rejected: not every social-
  science/humanities study involves human participants -- pure
  archival/textual-corpus analysis has no ethics-review requirement at
  all. Forcing the check onto every study would fabricate a
  requirement, contradicting the honest-coverage discipline
  `socialresearch.facts` already commits to for jurisdictions.
- **Merging human-subjects-review into the existing data-
  reproducibility-risk check** as one combined "research-ethics" flag.
  Rejected: the two are legally and procedurally distinct concerns
  (data integrity vs. human-subjects protection), with different
  citation sources per jurisdiction and different activation
  conditions (data-reproducibility-risk is unconditional;
  human-subjects-review is conditional on `:involves-human-
  subjects?`) -- merging them would lose that distinction.

## Consequences

- Seventy-eighth actor in this fleet (77 implemented before this
  build).
- Confirms the fleet-wide governor-name-reuse precedent a third time,
  and for the first time on a governor-name family other than
  `:repair-shop-governor` -- establishing it as a general pattern
  rather than a repair-shop-specific exception.
- Establishes a genuinely NEW unconditional-evaluation-screening
  concept (human-subjects-review-unconfirmed?, CONDITIONAL variant),
  grep-verified absent from every prior sibling before the claim was
  finalized.
- `MemStore` ‖ `DatomicStore` parity is proven by
  `test/socialresearch/store_contract_test.cljk`, the same `:db-api`-
  driven swap pattern every sibling actor uses.
- 34 tests / 159 assertions pass; lint is clean; the demo
  (`clojure -M:dev:run`) walks one clean actuation lifecycle plus five
  HARD-hold scenarios end-to-end.
- `blueprint.edn` required no field-sync fixes this time (already
  correct) -- only the `:maturity` flip itself.
