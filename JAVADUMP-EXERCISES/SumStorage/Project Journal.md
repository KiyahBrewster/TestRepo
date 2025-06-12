Project Process: 
Reviewed the brief and identified key features: locker rental, PIN-based access, and release.

Built an initial prototype using a single Main class, then refactored into separate classes (Locker, LockerService, TerminalUtils) for clarity and maintainability.

Used GitHub issues and branches to organize features and track progress.

Design Decisions: 
Created a Locker class to encapsulate locker details and a LockerService to manage core functions.

TerminalUtils handled repeated input logic, supporting DRY principles.

Used a 10-slot static array with null for availability tracking.

Challenges: 
Handled invalid input without crashing.

Balanced code simplicity with clean structure.

Avoided overcomplicating while maintaining clarity and modularity.

Reflection:
Extracted repeated code into reusable methods.

Used input validation and try-catch blocks to improve stability.

Focused method design on single responsibilities (e.g., prompting input, accessing lockers).

