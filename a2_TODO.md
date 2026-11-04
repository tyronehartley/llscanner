# Marked Items

## Simple river flows

- Language can interpret an expression describing simple river flows. Interpreter outputs something when it is finished indicating at least one of the flows in the system. 
- We recommend outputting all named flows, but you could have a special output for one expression. 
- Rainfall and river catchment size should be user-definable.

## Multi-day flow modelling

- Language can model the flow over multiple days. Output shows predicted flows on all those days. May output just one flow, or all named flows, or whatever makes most sense. Flows should carry over between days — predicted flows depend on previous days’ water, not just today’s rainfall.

## Dam syntax and grammar

- Language syntax supports dams. Dams don’t always let all or none of the flow through, they run some "algorithm" to decide how much flow to let through. Provide example programs demonstrating your dam syntax and parser can successfully parse those programs. Please include a full grammar here. Grammar should be complete and match your example programs, so the marker can write their own.

## Dam evaluation

- The interpreter can run the dam’s algorithm accurately and downstream river flows reflect its behaviour. Sensible behaviour for no-flow, half-flow, and full-flow dams; check the release fraction doesn’t exceed 1; dam parameters should be user-settable.

## Dam output depends on multiple factors

- The output from a dam can depend on at least two of the following: the flow into the dam, today’s rain, the dam level. You may add others if you like. Explain your design decisions and implementation steps — this explanation is worth half of this item’s marks.

## Log-book entries

- showing workshop engagement throughout the semester.
- No logbook = 0 marks.
- Complete and entries = full marks.

## How well does this language express the underlying concepts

- have you chosen sensible keywords and syntax structures
- have you implemented an interesting language overall
