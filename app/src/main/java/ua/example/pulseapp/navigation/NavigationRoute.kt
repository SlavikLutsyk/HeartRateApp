package ua.example.pulseapp.navigation

sealed class NavigationRoute(val route:String){
    object LoadingScreen : NavigationRoute("loading_screen")
    object OnBoardingScreen : NavigationRoute("on_boarding_screen")
    object HomePageScreen : NavigationRoute("home_page_screen")
    object MeasurementScreen : NavigationRoute("measurement_screen")
    object ResultScreen : NavigationRoute("result_screen")
    object HistoryScreen : NavigationRoute("history_screen")
}
