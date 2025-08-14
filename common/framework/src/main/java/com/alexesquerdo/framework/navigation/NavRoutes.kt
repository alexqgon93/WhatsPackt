package com.alexesquerdo.framework.navigation

object NavRoutes {
    const val ConversationsList = "conversation_list"
    const val NewConversation = "create_conversation"
    const val Chat = "chat/{chatId}"

    object ChatArgs {
        const val ChatId = "chatId"
    }
}