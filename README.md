# Java Name Sorter
Java name sorter. Given a set of names, order that set first by last name, then by any given
names the person may have. A name must have at least 1 given name and may have up to 3 given
names.

### Usage:
```bash
java -jar KstNameSorter-1.0-SNAPSHOT.jar  [unsorted file path] [sorted file path]
```

### Example:
```bash
java -jar KstNameSorter-1.0-SNAPSHOT.jar  unsorted-names-list.txt sorted-names-list.txt
```

or

create a file named unsorted-names-list.txt in working project directory, then run
```bash
java -jar KstNameSorter-1.0-SNAPSHOT.jar
```