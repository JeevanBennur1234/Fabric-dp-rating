# Fabric DP Rating Pro

A desktop Java application for evaluating Durable Press (DP) rating and wrinkling grades of textile fabrics using image processing techniques (Canny Edge Detection and replica comparison).

---

## 1. Requirements

- **Java**: JDK 8 or higher (Java 8, 11, 17, or 21)
- **IDE** (optional): NetBeans 8.2 or Apache NetBeans (12+)
- **Database**: Oracle Database Express Edition (XE 10g, 11g, 18c, or 21c)
  - Default Host: `localhost`
  - Default Port: `1521`
  - Default SID: `xe`
  - Default Database User: `system`
  - Default Database Password: `dkte`

---

## 2. Database Setup

The project includes the database schema and seed data in `database/database.sql`.

### Steps:
1. Start your Oracle Database service (`OracleServiceXE` and listener).
2. Open **SQL*Plus** or **Oracle SQL Developer** and log in:
   ```bash
   sqlplus system/dkte@localhost:1521/xe
   ```
3. Execute the setup script:
   ```sql
   @database/database.sql
   ```
4. This script creates the three required tables:
   - `REGISTRATION` (Employee ID, Password, Confirm Password)
   - `TESTINGINFORMATION1` (Fabric specifications: Lot Number, Tester Name, Fabric Type, EPI, PPI, Count, Date)
   - `RESULT` (Lot Number and computed DP Rating grade)

---

## 3. Login Credentials

| Role | Username | Password | Notes |
| :--- | :--- | :--- | :--- |
| **Admin** | `dkte123` | `dkte123` | Hardcoded system administrator (view full history, delete user, delete lot) |
| **User** | `ramesh12` | `Arn@157744974` | Pre-seeded user (or create a new account using the registration screen) |

---

## 4. How to Build and Run

### Method 1: Using 1-Click Batch Files (Recommended on Windows)
- **To Build**: Double-click `build.bat` (compiles source files and creates `dist/DPRating.jar` with all dependencies).
- **To Run**: Double-click `run.bat` (launches the application directly).

### Method 2: In NetBeans IDE
1. Launch **NetBeans**.
2. Go to **File -> Open Project...**
3. Browse and select the `DPRating` folder.
4. Right-click the `DPRating` project in the Projects panel and select **Clean and Build**.
5. Click the green **Run** button (or press `F6`) to launch the application.

### Method 3: From Command Line
```bash
# Build
cmd /c build.bat

# Run
java -jar dist\DPRating.jar
# or
java -cp "dist\DPRating.jar;dist\lib\*" dprating.DPRating
```

---

## 5. Project Directory Structure

```text
DPRating/
|-- src/
|   |-- dprating/              # Java source files
|   |-- JARS/                  # All 14 required third-party JAR dependencies
|   |-- Replica/               # Fabric replica standard images
|   |-- ui/                    # UI icon assets
|   |-- *.jpg, *.gif           # Application image resources
|-- database/
|   `-- database.sql           # Complete Oracle database creation & seed script
|-- nbproject/                 # Portable NetBeans project configuration
|   |-- project.properties     # Relative JAR and compile paths
|   `-- project.xml            # NetBeans project metadata
|-- dist/                      # Generated binaries (built output)
|   |-- DPRating.jar           # Main executable application JAR
|   `-- lib/                   # Bundled dependency JARs
|-- build.bat                  # Standalone Windows build script
|-- run.bat                    # Standalone Windows run script
|-- build.xml                  # Ant build file with NetBeans lifecycle hooks
`-- README.md                  # Project documentation
```

---

## 6. Portability Notes

- All JAR dependencies use **project-relative paths** (`src/JARS/...`), ensuring the project compiles on any Windows machine without requiring external path configuration.
- Machine-specific absolute paths from previous developer setups have been completely removed.
- Resource images are copied into `src/` to guarantee they are packaged directly inside `dist/DPRating.jar`.
