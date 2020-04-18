
# MyAndroidSchool

I will be pushing all the android applications I develop as a part of pursuing the Android starter course with Kotlin in Udacity and the Kotlin android fundamentals codelab

#### Shortcuts
* **Alt+Shift+C**: Recent changes
* **Shift x 2**: Search everywhere
* **Alt+Right(or Left)**: Switch between active tabs
* **Ctrl+O**: Override methods 

## Random notes :)
#### Activities
* An _activity_ represents a single screen in your app with an interface the user can interact with.
#### Intents
* Each activity is started or activated with an  `Intent`, which is a *message object* that makes a request to the Android runtime to start an activity or other app component in your app or in some other app.
* In addition to simply starting one `Activity` from another `Activity`, you also use an `Intent` to _pass information_ from one `Activity` to another.
* Intents can be _explicit_ or _implicit_:
>* *Implicit*: You do not specify a class to recieve the intent. Instead, you declare a general action to perform, and the Android system matches your request to an activity/other component that can handle the requested action.
>* *Explicit*: You specify the receiving activity (or other component) using the activity's fully qualified class name.
* To get data back from a launched `Activity`, start that `Activity` with the `startActivityForResult()` method instead of `startActivity()`
* Call `finish()` to close the `Activity` and resume the originating `Activity`
### Broadcast
<img src="https://user-images.githubusercontent.com/20596763/79630313-e6b10280-816d-11ea-93e5-797ae92bea82.png" width=700>

*Broadcasts* are messages that the Android system and Android apps send when events occur. 

* **System broadcasts** are delivered by the system.
* **Custom broadcasts** are delivered by your app.


#### System broadcasts
* A system broadcast is a message that the Android system sends when a system event occurs. 
* System broadcasts are **wrapped in Intent objects**.

> ###### Examples:
>* When the device boots, the system broadcasts a system Intent with the action ```ACTION_BOOT_COMPLETED```
>* When the device is disconnected from external power, the system sends a system Intent with the action field ```ACTION_POWER_DISCONNECTED```.
#### Custom broadcasts
* Custom broadcasts are broadcasts that your app sends out.
* Use a custom broadcast when you want your app to take an action without launching an activity.
* To create a custom broadcast, define a custom Intent action.
##### There are three ways to deliver a custom broadcast:
1. For a **normal broadcast**, pass the intent to ```sendBroadcast()```.
>* The sendBroadcast() method sends broadcasts to **all the registered receivers at the same time**, in **an undefined order**. 
>* Most efficient way to send a broadcast
2. For an **ordered broadcast**, pass the intent to ```sendOrderedBroadcast()```
> To send a broadcast to one receiver at a time, use the 
> `sendOrderedBroadcast()`  method:
> -   The  `android:priority`  attribute that's specified in the intent filter determines the order in which the broadcast is sent.
> -   If more than one receiver with same priority is present, the sending order is random.
> -   The  `Intent`  is propagated from one receiver to the next.
> -   During its turn, a receiver can update the  `Intent`, or it can cancel the broadcast. (If the receiver cancels the broadcast, the 
> `Intent`  can't be propagated further.)

3. For a **local broadcast**, pass the intent to ```LocalBroadcastManager.sendBroadcast()```.

> * Sends broadcasts to receivers **within your app.**
> * This method is efficient, because it doesn't involve interprocess communication. 
> * Also, using local broadcasts protects your app against some security issues

[Click here](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-3-working-in-the-background/lesson-7-background-tasks/7-3-c-broadcasts/7-3-c-broadcasts.html#normal-broadcasts) for broadcast methods in java

#### Broadcast receivers
* Broadcast receivers are app components that can register for system events or app events.
* When an event occurs, registered broadcast receivers are notified via an  `Intent`.

Use broadcast receivers to respond to messages that have been broadcast from apps or from the Android system. To create a broadcast receiver:

1.  **Define a subclass** of the  `BroadcastReceiver` class and implement the  `onReceive()`  method.
2.  **Register** the broadcast receiver, either statically or dynamically.
