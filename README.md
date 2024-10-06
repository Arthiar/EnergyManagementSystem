# Energy Management System

## Overview

The **Energy Management System** is a Java project designed to simulate the management of log files for various charging stations and energy sources. It supports creating, appending, moving, archiving, and deleting log files, while also simulating data exchange using byte and character streams.

## Features

- **Log File Management**:
  - Creates and appends log files for different charging stations and energy sources.
  - Moves log files to the `archived_logs` folder.
  - Archives log files into `.zip` format.
  - Deletes the original log files after archiving.

- **Data Exchange Simulation**:
  - Simulates data exchange using both byte streams (binary data) and character streams (text data).

- **Log Retrieval**:
  - Allows the user to open and retrieve logs based on the equipment name and the date.

## Project Structure


## Prerequisites

- Java Development Kit (JDK) 11 or higher installed.
- Eclipse IDE (or any other Java-compatible IDE).

## Setup and Installation

1. **Clone this repository** or download the ZIP file.
2. **Open the project in Eclipse**:
   - Select `File` > `Import` > `Existing Projects into Workspace`.
   - Browse to the project folder and import it.
3. **Ensure the `archived_logs` folder exists**:
   - Right-click on the project folder in Eclipse.
   - Select `New` > `Folder` and create a folder named `archived_logs`.
4. **Run the project**:
   - Open `EnergyManagementSystemMain.java`.
   - Right-click and select `Run As` > `Java Application`.

## Example Output

After running the program, you will see output like this in the console:



## Key Methods

- `createLog(String logFileName)`: Creates or appends to a log file with the current timestamp.
- `moveLog(String sourcePath, String destinationPath)`: Moves the log file to the `archived_logs` folder.
- `deleteLog(String logFileName)`: Deletes the log file after it has been archived.
- `archiveLog(String logFileName)`: Archives the log file into `.zip` format.
- `simulateByteStream(String fileName)`: Simulates binary data exchange.
- `simulateCharacterStream(String fileName)`: Simulates text data exchange.
- `openLogFile(String equipment, String date)`: Opens a log file based on the name of the equipment and date.

## Conclusion

This Energy Management System automates the logging, archiving, and deletion of log files for multiple charging stations and energy sources. It demonstrates essential file management operations in Java, such as creating, moving, archiving, and deleting files. It also simulates data exchange using byte and character streams, making it a comprehensive project for energy management simulation.

Feel free to modify or extend the functionality to suit your own requirements. Contributions are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
