package com.tien.inventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tien.inventory.ui.home.HomeScreen
import com.tien.inventory.ui.item.ItemDetailsScreen
import com.tien.inventory.ui.item.ItemEditScreen
import com.tien.inventory.ui.item.ItemEntryScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${ItemDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = ItemEntryDestination.route) {
            ItemEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}

/**
 * Interface to describe the navigation destinations used in the app
 */
interface NavigationDestination {
    val route: String
    val titleRes: Int
}

/**
 * Destination for Home Screen
 */
object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = 0 // Will use stringResource in Screen
}

/**
 * Destination for Item Entry Screen
 */
object ItemEntryDestination : NavigationDestination {
    override val route = "item_entry"
    override val titleRes = 0
}

/**
 * Destination for Item Details Screen
 */
object ItemDetailsDestination : NavigationDestination {
    override val route = "item_details"
    override val titleRes = 0
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

/**
 * Destination for Item Edit Screen
 */
object ItemEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = 0
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}
