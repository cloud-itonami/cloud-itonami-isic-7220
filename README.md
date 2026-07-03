# cloud-itonami-7220

Open Business Blueprint for **ISIC Rev.5 7220**: Research and experimental development on social sciences and humanities.

This repository designs a forkable OSS business for research and experimental development on social sciences and humanities -- systematic study to increase knowledge of society, behavior, culture and history -- run by a qualified, licensed operator so a community or
independent professional never surrenders customer data and ledgers to a
closed SaaS.

## Robotics premise

All cloud-itonami verticals are designed on the premise that a **robot performs
the physical domain work**. Here a document-archive robot manages physical survey/archival material custody,
under an actor that proposes actions and an independent **Research Integrity Governor**
that gates them. The governor never dispatches hardware itself;
`:high`/`:safety-critical` actions require human sign-off.

## Core Contract

```text
intake + identity + engagement records
        |
        v
StudyOps-LLM -> Research Integrity Governor -> hold, proceed, or human approval
        |
        v
engagement ledger + evidence record + audit
```

No automated proposal, by itself, can complete the following without governor
approval and audit evidence: publishing a findings report.

## Capability layer

This blueprint resolves its technology stack via
[`kotoba-lang/industry`](https://github.com/kotoba-lang/industry) (ISIC
`7220`).

This vertical's engagement records are practice-specific rather than a shared
cross-operator data contract, so it runs on the generic identity/forms/dmn/
bpmn/audit-ledger stack only -- no bespoke domain capability lib.

See [`docs/business-model.md`](docs/business-model.md) and
[`docs/operator-guide.md`](docs/operator-guide.md).

## Maturity

`:blueprint` -- this repository is the published business/operator design.
The governed actor implementation (`StudyOps-LLM` + `Research Integrity Governor` as
running code) is a follow-up, same as any other `:blueprint`-tier
`cloud-itonami-*` entry in `kotoba-lang/industry`'s registry.

## License

Code and implementation templates are AGPL-3.0-or-later.
