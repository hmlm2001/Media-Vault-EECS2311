-- Delete mediavault database
DROP DATABASE mediavault;

-- Revoke all privileges and delete mediavaultadmin user
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'mediavaultadmin'@'localhost';
DROP USER 'mediavaultadmin'@'localhost';
