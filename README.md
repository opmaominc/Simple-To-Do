# SimpleTodo

SimpleTodo is an Android app in which one can add, edit, view, delete a list of todo items. Below is a screenshot of the app.

## Installation
Android Studio required. SimpleTodo supports Android v5.0.1
Copy all files and into your project.

## Usage
There are two activities: Main and Edit. Main Activity implements the list of todo items and textfield used to add items. 

The following methods are used to read and write data to local txt file.

```java
 public void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    public void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

The following method is used to add item to your todo list.
```java
 public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }
```

Edit Activity implements the edit textfield used to edit the selected todo item.

```java
 public void saveNewItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.editText);
        String itemText = etNewItem.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("item",itemText);
        intent.putExtra("position",position);
        setResult(RESULT_OK, intent);
        finish();
    }
```

Once back to the Main Activity, the following method updates the todo item with the new edited one.

```java
  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String item = intent.getExtras().getString("item");
            int position = intent.getExtras().getInt("position");
            items.set(position, item);
            itemsAdapter.notifyDataSetChanged();
            writeItems();
        }
    }
```

## History
1.0 - Initial commit - Simple Todo app.

## License
This project uses MIT License.
