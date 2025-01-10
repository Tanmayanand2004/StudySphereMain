-- Users Table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Store hashed password
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Study Materials Table
CREATE TABLE StudyMaterials (
    material_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    file_link VARCHAR(255), -- Link to study material
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- User-Material Relationship Table (optional)
CREATE TABLE UserMaterials (
    user_id INT,
    material_id INT,
    PRIMARY KEY (user_id, material_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (material_id) REFERENCES StudyMaterials(material_id) ON DELETE CASCADE
);
