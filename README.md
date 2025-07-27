# Twitter RandomAccess Replica

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

  
## Project Description

**Twitter RandomAccess Replica** is a simplified simulation of Twitter’s data storage and timeline system using a custom-built, file-based database. This implementation uses **Random Access File I/O** to read and write user and tweet data efficiently without relying on external databases.

The project is designed to replicate the behavior of core Twitter functionalities, including tweet posting, following users, and generating a personalized timeline, all within a self-contained Java system using `.dat` and `.idx` files as persistent storage.

This version emphasizes **manual data structure management** and file positioning, providing an educational deep dive into how low-level data systems can power social media logic.

  
## Features

- Custom **file-based database system** (`.dat` and `.idx`)  
- Efficient **random access read/write** for performance  
- Supports posting tweets and following users  
- Reconstructs timeline from indexed files  
- No external dependencies—runs entirely on the JVM  


## Technologies Used

- **Java** — Core language for system logic and file I/O



## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Git

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/darrellathaya/low_twitter_randomaccess_owndb.git
   cd low_twitter_randomaccess_owndb
   ```

2. **Compile the Project**
   ```bash
   javac *.java
   ```


## Usage Guide

### Post a Tweet
```bash
java Post <username> "<message>"
```

### Follow a User
```bash
java Follow <follower> <followee>
```

### View Timeline
```bash
java Timeline <username>
```



## Project Structure

```
twitter-randomaccess-owndb/
├── Follow.java                     # Defines user follow relationships
├── Follow.class
│
├── Post.java                       # Creates and stores tweets
├── Post.class
│
├── Timeline.java                   # Builds the user timeline from file data
├── Timeline.class
│
├── posts.dat                       # Raw tweet content storage (binary format)
├── posts.idx                       # Index file mapping tweet offsets for quick access
├── followers.dat                   # List of followers per user
├── follows.dat                     # User follow records
├── subscriptions.dat               # User subscriptions (who they follow)
│
├── README.md                       # Project documentation
```

---

## License

This project is licensed under the MIT License.
