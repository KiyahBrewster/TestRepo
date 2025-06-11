-------Project Journal--------
Project Process:
The project began by reviewing the requirements for a storage locker access system used by guest services staff. I broke down the functionality into clear features, following the GitHub issue checklist, including renting, accessing, and releasing lockers.

Design Decisions:

I used a String[] array to represent lockers and their assigned 4-digit PINs, with null indicating an available locker.

PINs were generated as random integers and formatted with String.format("%04d") to preserve leading zeros.

I created methods for each feature (rentLocker, accessLocker, releaseLocker) to keep the logic separated and easier to debug or update.

User interaction was handled via Scanner, and all inputs were validated with try-catch blocks.

Challenges:

Ensuring that leading zeroes in PINs were preserved during formatting.

Avoiding repetitive code when prompting for input and validating locker numbers.

Making the menu dynamically remove the "Rent a Locker" option when all lockers are full.

DRY Principle & Method Design:
I applied the DRY principle by:

Creating reusable methods like prompt(), generatePin(), and isValidLocker() to avoid repeating logic.

Using helper methods to keep the main logic clear and focused on flow rather than implementation detail.

Error Handling:
All user input is wrapped in try/catch blocks to prevent crashes from invalid types. For example, entering text when a number is expected prompts the user again rather than breaking the program.

-------Conclusion-------
This project demonstrates how to translate a detailed software specification into a functioning prototype. I followed the instructions and menu design to implement a locker system with clearly defined functionality, using arrays for state tracking and string manipulation for PIN generation.

Through this build, I improved my ability to:

Use arrays and strings effectively.

Apply exception handling to make a program crash-resistant.

Separate logic into modular methods that follow the DRY principle.

The prototype meets all the acceptance criteria and is ready for QA testing. Overall, this project reinforced my understanding of Java fundamentals, input validation, and real-world problem modeling.

