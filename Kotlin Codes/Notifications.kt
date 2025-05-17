fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages == 0) {
        println("You have no new notifications.")
    } else if (numberOfMessages == 1) {
        println("You have 1 new notification.")
    } else if (numberOfMessages in 2..99) {
        println("You have $numberOfMessages new notifications.")
    } else {
        println("You have 99+ new notifications.")
    }
}