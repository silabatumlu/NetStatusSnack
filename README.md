#  Network Status Observer

A simple utility to **observe network connectivity changes** in Android using **Kotlin Coroutines** and **Flows**.  

This helps you detect when the device goes **online** or **offline**, so you can show a Snackbar, Toast, or any UI feedback in real time.

  Features
-  Detects when network becomes **Available**  
-  Detects when network becomes **Unavailable** or **Lost**  
-  Exposes connectivity updates as a **Flow**  
-  Built with **callbackFlow** and **Coroutines**  
-  Automatically unregisters callbacks to avoid leaks  
