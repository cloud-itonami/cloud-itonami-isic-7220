# Business Model: Research and experimental development on social sciences and humanities

## Classification

- Repository: `cloud-itonami-isic-7220`
- ISIC Rev.5: `7220`
- Activity: research and experimental development on social sciences and humanities -- systematic study to increase knowledge of society, behavior, culture and history
- Social impact: professional standards, data sovereignty, transparent audit

## Customer

- independent social-research institutes
- cooperative research consortia
- community/policy-research programs

## Offer

- study-design intake
- data-collection proposal
- findings-report proposal
- immutable audit ledger

## Revenue

- self-host setup: one-time implementation fee
- managed hosting: monthly subscription per institute
- support: monthly retainer with SLA
- migration: import from an incumbent research-management system
- per-study fee

## Trust Controls

- no findings report is published without human sign-off
- fabricated or unreproducible data forces a hold, not an override
- a study involving human subjects cannot be published without a
  confirmed human-subjects-research-ethics-review (IRB/ethics
  committee) approval on file -- unconfirmed, this is a hold, never an
  override
- every publication path is auditable
- emergency manual override paths remain outside LLM control

## Research Integrity Governor: decision rule

This vertical's governor shares its name (`:research-integrity-
governor`) with `cloud-itonami-isic-7210`'s (research and experimental
development on natural sciences and engineering). This is a deliberate
reuse, not a naming error: both actors perform research-integrity
oversight of an R&D lab publishing findings reports, differing only in
subject domain. The genuinely distinguishing concern this vertical
adds is human-subjects-research ethics review: surveys, interviews,
focus groups and ethnographic fieldwork on human participants are
characteristic of social-science research and essentially absent from
natural-science/engineering R&D. A study that itself declares it
involves human subjects cannot proceed to publication without a
confirmed ethics-review approval; a study that does not involve human
subjects (e.g. pure archival/textual-corpus analysis) carries no such
requirement at all.
