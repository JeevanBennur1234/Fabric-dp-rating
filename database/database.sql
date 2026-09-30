-- ============================================================
-- DP Rating Pro - Oracle Database Setup Script
-- Compatible with Oracle Database 10g / 11g / 18c / 21c XE
-- Run in SQL*Plus or Oracle SQL Developer as: system / dkte
-- Host: localhost | Port: 1521 | SID: xe
-- ============================================================

-- Drop existing tables if re-running (safe execution)
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE result CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE testinginformation1 CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE registration CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- ------------------------------------------------------------
-- 1. User Registration Table
-- ------------------------------------------------------------
CREATE TABLE registration (
    EMPLOYEEID   VARCHAR2(50)  PRIMARY KEY,
    PASSWORD     VARCHAR2(50)  NOT NULL,
    CONFIRMPASS  VARCHAR2(50)  NOT NULL
);

-- ------------------------------------------------------------
-- 2. Fabric Testing Information Table
-- ------------------------------------------------------------
CREATE TABLE testinginformation1 (
    LOT_NUM      NUMBER        PRIMARY KEY,
    TESTERNAME   VARCHAR2(50)  NOT NULL,
    FABRICNAME   VARCHAR2(50)  NOT NULL,
    EPI          NUMBER        NOT NULL,
    PPI          NUMBER        NOT NULL,
    READ_COUNT   NUMBER        NOT NULL,
    VIEW1        VARCHAR2(50)  NOT NULL,
    FINISHTYPE   VARCHAR2(100) NOT NULL,
    VARPCOUNT    NUMBER        NOT NULL,
    WEFTCOUNT    NUMBER        NOT NULL,
    CURRUNTDATE  VARCHAR2(30)
);

-- ------------------------------------------------------------
-- 3. DP Rating Result Table
-- ------------------------------------------------------------
CREATE TABLE result (
    LOT_NUM      NUMBER        PRIMARY KEY,
    CATEGORY     FLOAT         NOT NULL
);

-- ------------------------------------------------------------
-- Pre-seeded User Account (from project documentation)
-- ------------------------------------------------------------
INSERT INTO registration (EMPLOYEEID, PASSWORD, CONFIRMPASS)
VALUES ('ramesh12', 'Arn@157744974', 'Arn@157744974');

COMMIT;

-- ============================================================
-- Verification: Check that all 3 tables exist
-- ============================================================
SELECT table_name FROM user_tables
WHERE table_name IN ('REGISTRATION', 'TESTINGINFORMATION1', 'RESULT');

-- Note: Admin login is hardcoded in the application:
-- Username: dkte123
-- Password: dkte123

