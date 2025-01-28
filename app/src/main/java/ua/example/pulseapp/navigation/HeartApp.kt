package ua.example.pulseapp.navigation

import android.content.Context
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.example.pulseapp.MainActivity
import ua.example.pulseapp.R
import ua.example.pulseapp.models.HistoryResult
import ua.example.pulseapp.screens.*
import ua.example.pulseapp.viewModel.HeartViewModel
import ua.example.pulseapp.viewModel.HeartViewModelFactory

@Composable
fun HeartApp(
    navHostController: NavHostController,
    context: Context
) {
    val heartViewModel: HeartViewModel = viewModel(factory = HeartViewModelFactory(context))

    val historyState by  heartViewModel.historyState

    val isLoading: MutableState<Boolean> = remember { mutableStateOf(historyState.loading) }
    NavHost(navController = navHostController, startDestination = NavigationRoute.LoadingScreen.route ){
        composable(NavigationRoute.LoadingScreen.route){
            LoadingScreen(isLoading){
                navHostController.navigate(NavigationRoute.OnBoardingScreen.route)
            }
        }
        composable(NavigationRoute.OnBoardingScreen.route){
            OnBoardingScreen(){
                navHostController.navigate(NavigationRoute.HomePageScreen.route)
            }
        }
        composable(NavigationRoute.HomePageScreen.route){
            HomePageScreen(context, {
                navHostController.navigate(NavigationRoute.MeasurementScreen.route)
            }){
                navHostController.navigate(NavigationRoute.HistoryScreen.route)
            }
        }
        composable(NavigationRoute.MeasurementScreen.route){
            MeasurementScreen(false, {
                navHostController.navigate(NavigationRoute.HomePageScreen.route)
            }){
                val insertState = heartViewModel.insertRecord(it)
                if (!insertState.value.loading) {
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("result", it)
                    navHostController.navigate(NavigationRoute.ResultScreen.route)
                }
            }
        }
        composable(NavigationRoute.ResultScreen.route){
            val res = navHostController.previousBackStackEntry?.savedStateHandle?.
            get<HistoryResult>("result")?:HistoryResult(0,0,"")
            ResultScreen(context = context, res = res, {
                navHostController.navigate(NavigationRoute.HistoryScreen.route)
            }) {
                navHostController.navigate(NavigationRoute.HomePageScreen.route)
            }
        }
        composable(NavigationRoute.HistoryScreen.route){
            HistoryScreen(historyState.list, {
                navHostController.navigate(NavigationRoute.HomePageScreen.route)
            }){
                val deleteState = heartViewModel.deleteHistory()
                if (!deleteState.value.loading)
                    navHostController.navigate(NavigationRoute.HistoryScreen.route)
            }
        }

    }
}