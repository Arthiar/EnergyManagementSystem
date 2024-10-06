package com.energymanagement;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;

public class EnergyManagementSystemMain {

    // Method to create or append to a log file
    public static void createLog(String logFileName) throws IOException {
        File logFile = new File(logFileName);

        // If file already exists, append to it
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write("This is an appended log entry for " + logFileName + " at " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "\n");
            System.out.println("Appended log entry to: " + logFileName);
        }
    }

    // Method to move log files
    public static void moveLog(String sourcePath, String destinationPath) throws IOException {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);
        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Log file moved to: " + destinationPath);
    }

    // Method to delete a log file
    public static void deleteLog(String logFileName) {
        File logFile = new File(logFileName);
        if (logFile.delete()) {
            System.out.println("Deleted the file: " + logFileName);
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    // Method to archive log files into a .zip file
    public static void archiveLog(String logFileName) throws IOException {
        String archiveName = logFileName + ".zip";
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(archiveName))) {
            zos.putNextEntry(new ZipEntry(logFileName));
            Files.copy(Paths.get(logFileName), zos);
            zos.closeEntry();
        }
        System.out.println("Log file archived: " + archiveName);
    }

    // Simulate data exchange with byte streams (e.g., binary data)
    public static void simulateByteStream(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
            String data = "Binary data for " + fileName + "\n";
            fos.write(data.getBytes());
            System.out.println("Simulated byte stream data written to: " + fileName);
        }
    }

    // Simulate data exchange with character streams (e.g., text data)
    public static void simulateCharacterStream(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String data = "Text data for " + fileName + "\n";
            writer.write(data);
            System.out.println("Simulated character stream data written to: " + fileName);
        }
    }

    // Method to open a log file based on equipment or date
    public static void openLogFile(String equipment, String date) {
        String fileName = "archived_logs/" + equipment + "_log_" + date + ".txt.zip";
        File logFile = new File(fileName);

        if (logFile.exists()) {
            System.out.println("Opening log file: " + fileName);
            // In a real application, you would open the file here.
        } else {
            System.out.println("Log file not found: " + fileName);
        }
    }

    public static void main(String[] args) {
        try {
            // Example: Equipment and energy sources
            String[] stations = {"StationA", "StationB"};
            String[] sources = {"Solar", "Wind", "Hydro"};

            for (String station : stations) {
                for (String source : sources) {
                    String logFileName = station + "_" + source + "_log_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".txt";
                    
                    // Step 1: Create or append to log file for the station and source
                    createLog(logFileName);  // Create or append to log file
                    
                    // Simulate data exchange (byte and character streams)
                    simulateByteStream(logFileName);
                    simulateCharacterStream(logFileName);

                    // Step 2: Move the log file to the "archived_logs" folder
                    moveLog(logFileName, "archived_logs/" + logFileName);

                    // Step 3: Archive the log file
                    archiveLog("archived_logs/" + logFileName);

                    // Step 4: Delete the original log file after archiving
                    deleteLog("archived_logs/" + logFileName);
                }
            }

            // Example usage of opening a log file based on equipment and date
            String equipment = "StationA_Solar";  // Example input
            String date = new SimpleDateFormat("yyyyMMdd").format(new Date());  // Today's date
            openLogFile(equipment, date);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
