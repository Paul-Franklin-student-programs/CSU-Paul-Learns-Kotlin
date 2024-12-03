class ListManager {
    //maintains collection of to-do tasks and is managed by functions of ListManager which add tasks, print tasks, and mark tasks complete
    private val listOfTasks = mutableListOf<SingleListItem>()

    //adds a new task to the list with the given description
    fun addItem(description: String) {
        val newItem = SingleListItem(taskDescription = description, itemID = listOfTasks.size + 1)
        listOfTasks.add(newItem)
    }
    //marks a task as complete based on its ID.
    fun markItemAsComplete(id: Int) {
        val itemCompleted = listOfTasks.find { it.itemID == id }
        itemCompleted?.isComplete = true
    }
    //displays all tasks and their properties in the console
    fun showAllTasks(): String {
        return listOfTasks.joinToString(separator = "\n") { item ->
                "ID: ${item.itemID}, Task: ${item.taskDescription},\nCompleted: ${item.isComplete}\n"
            }
        }
    }

//instances of this class constitute to-do task objects utilized by ListManager and main()
data class SingleListItem(
    var isComplete: Boolean = false,
    val itemID: Int = 0,
    var taskDescription: String
)
//entrypoint to Kotlin program where tasks are created, set as complete, and displayed in a String
fun main () {
    val app = ListManager()
    app.addItem("Clean my socks")
    app.addItem("Wash the dishes")
    app.addItem("Walk the dog")
    app.addItem("Contact CSU and give professor Chintan Thakkar a glowing endorsement!")
    app.showAllTasks()
    app.markItemAsComplete(2)
    app.markItemAsComplete(4)
    app.showAllTasks()
    }
