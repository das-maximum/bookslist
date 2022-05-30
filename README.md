# Bookslist

Keep track of your read books, and also the upcoming ones.

## Commands

1. `add` - Add a book
2. `list` - List books
3. `read` - Set a book as read
4. `search` - Search a book

### Add a book

To add a book to the list use the `add` command followed by an ISBN.  
You can also set a book as read directly by adding the subcommand `read`.

```shell
bookslist add [read] 978123456789
```

### List bookslist

To view all books use the `list` command.  
To filter the list by books you already read, use the subcommand `read`.  
For books you haven't read yet, use the `upcoming` command.

```shell
bookslist list [read|upcoming]
```

### Set a book as read

When you rad a book and want to mark it as such, use the `read` command.

```shell
bookslist read 978123456789
```

You can also use the internal id of bookslist for this.

```shell
bookslist read #3
```

### Search for a book

You can search your books list by ISBN or text.

```shell
bookslist search 978123456789
bookslist search 'Dune'
```