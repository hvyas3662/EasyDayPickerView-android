# EasyDayPicker-android

EasyDayPicker :- A android library helps you to select one or more weekday(s). 

[![](https://jitpack.io/v/hvyas3662/EasyDayPicker-android.svg)](https://jitpack.io/#hvyas3662/EasyDayPicker-android)

<img src="ss.jpg" width="300" height="533">


## How to use

 For a working implementation, please have a look at the app directory
 1. Add maven in your root build.gradle at the end of repositories
 2. Add the dependency
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.hvyas3662:EasyDayPicker-android:1.0'
}
```

## How do I use EasyDayPicker?

 1. add DayPicker view in yout xml file  
 
 ```xml
    <com.hvyas.easydaypicker.DayPicker
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:layout_weight="1"
        app:DayBtnBackground="@drawable/daybtnbackground_round"
        app:DayBtnMargin="2dp"
        app:DayBtnSelectedTextColor="@android:color/white"
        app:DayBtnTextAppearance="@style/easyDayPickerDefaultBtnStyle"
        app:DayBtnTextSize="5sp"
        app:DayBtnUnSelectedTextColor="@android:color/black"
        app:SelectedDay="monday" />
 ```
 
 2. Other xml attribute are
 
  ```xml
  ```
 

## Customization

   * image compression format (e.g. PNG, JPEG, WEBP), compression
   * image compression quality [0 - 100]. PNG which is lossless, will ignore the quality setting.
   * whether all gestures are enabled simultaneously
   * maximum size for Bitmap that is decoded from source Uri and used within crop view. If you want to override default behaviour.
   * toggle whether to show crop frame/guidelines
   * setup color/width/count of crop frame/rows/columns
   * choose whether you want rectangle or oval crop area
   * the UI colors (Toolbar, StatusBar, active widget state)
   * and more...

## Compatibility
  
  * Requires minimum android API 21 or above
