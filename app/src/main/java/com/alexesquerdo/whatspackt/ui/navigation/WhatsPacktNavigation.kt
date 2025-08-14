package com.alexesquerdo.whatspackt.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alexesquerdo.chat.ChatScreen
import com.alexesquerdo.conversations.ui.ConversationsListScreen
import com.alexesquerdo.create_chat.ui.CreateConversationScreen
import com.alexesquerdo.framework.navigation.NavRoutes

@Composable
fun MainNavigation(navController: NavHostController) = NavHost(
    navController = navController,
    startDestination = NavRoutes.ConversationsList
) {
    addConversationsList(navController)
    addNewConversation(navController)
    addChat(navController)
}

private fun NavGraphBuilder.addConversationsList(navController: NavHostController) =
    composable(route = NavRoutes.ConversationsList) {
        ConversationsListScreen(
            onNewConversationClick = {
                navController.navigate(route = NavRoutes.NewConversation)
            },
            onConversationClick = { chatId ->
                navController.navigate(
                    route = NavRoutes.Chat.replace("{chatId}", chatId)
                )
            })
    }

private fun NavGraphBuilder.addNewConversation(navController: NavHostController) =
    composable(route = NavRoutes.NewConversation) {
        CreateConversationScreen(onCreateConversation = {
            navController.navigate(route = NavRoutes.Chat)
        })
    }

private fun NavGraphBuilder.addChat(navController: NavHostController) =
    composable(
        route = NavRoutes.Chat,
        arguments = listOf(navArgument(name = NavRoutes.ChatArgs.ChatId) {
            type = NavType.StringType
        })
    ) { backStackEntry ->
        val chatId = backStackEntry.arguments?.getString(NavRoutes.ChatArgs.ChatId)
        ChatScreen(chatId = chatId, onBack = { navController.popBackStack() })
    }
