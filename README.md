# This is a repository to prepare for the Hands-on workshop at Devfest HCMC 2024

## Overview

Trong phần thực hành này, bạn sẽ thực hiện một layout mô phỏng màn hình Home entry của Spotify
Thông qua việc phân tích các chuyển động xoay ngang, xoay dọc, resize window trên các thiết bị lớn để tìm hiểu cơ chế adaptive layouts phụ thuộc vào những yêu tố gì.
Những composable pattern hiện có nào đang đáp ứng được yêu cầu adaptive layout?

## Scenario

Như hầu hết các ứng dụng Android cần thể hiện UI tốt trên các kích thước màn hình khác nhau nhằm mục đích cải thiện trải nghiệm người dùng, tăng rating.
Với việc ngày càng nhiều các thiết bị lớn như foldable phone, tablet, chromebook đòi hỏi các ứng dụng cần thể hiện tốt hơn sự đa năng trong việc hiển thị.

## Target

- Build Adaptive Navigation trên các dạng màn hình Compact, Medium, Expanded

<div style="display: flex; flex-wrap: wrap; gap: 10px;">
  <img src="https://github.com/user-attachments/assets/f213b55e-993b-4420-be8c-3aa5b83d193d" alt="Image 1" style="width: 20%;">
  <img src="https://github.com/user-attachments/assets/5b58d20a-5ca6-4d35-8858-4ece13891813" alt="Image 2" style="width: 30%;">
  <img src="https://github.com/user-attachments/assets/fab7ec5c-37a5-4d48-8bc1-a1aaa36a46fb" alt="Image 3" style="width: 50%;">
</div>

- Đảm bảo ứng dụng liên tục khi resize, change settings

## References

- Layout Spotify app on Phone, Tablet, Chromebook 

<div style="display: flex; flex-wrap: wrap; gap: 10px;">
  <img src="https://github.com/user-attachments/assets/36c25e71-e767-4dbe-b847-50fb9feb7150" alt="Image 1" style="width: 10%;">
  <img src="https://github.com/user-attachments/assets/e17a0d50-d867-417b-95b2-9cb07b202ef2" alt="Image 2" style="width: 40%;">
  <img src="https://github.com/user-attachments/assets/79f32ca0-7b4f-42dd-8c13-23794f05d484" alt="Image 3" style="width: 50%;">
</div>

- Json Data: [Spotify web api](https://developer.spotify.com/documentation/web-api)

- Figma tham khảo: [Spotify - Mobile UI Kit](https://www.figma.com/community/file/1052832340031141040)

## Prerequisites

- JDK >= 11 
- Android Studio Koala or latest
- Gradle >= 8.5.2
- Kotlin >= 1.8 

## Jetpack Compose in Project

- Using Compose BOM 2024.09.03

 ```kotlin
 implementation(platform("androidx.compose:compose-bom:2024.09.03"))`
```

- Compose extension options: 

```kotlin
 composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
```

- [Material 3](https://m3.material.io/)


## Code overview


The starter code chứa các màn hình sau đây

![gif](https://github.com/user-attachments/assets/db77cad8-9eb5-4a7b-b7f6-c74a86733fc6)

## Instructions

Step 1: Sử dụng WindowSizeClass để quyết định hiển thị UI trên các loại thiết bị khác nhau 

```kotlin
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material3:material3-window-size-class")
```

- Sử dụng [WindowSizeClass](https://developer.android.com/develop/ui/compose/layouts/adaptive/use-window-size-classes) 

Step 2: Navigation

- Sử dụng [NavigationSuiteScafford](https://developer.android.com/develop/ui/compose/layouts/adaptive/build-adaptive-navigation) để thiết lập các bố trí các dạng Navigation khác nhau mà ko cần quan tâm đến WindowSizeClass (follow Material 3)

- Nếu có các custom đặc biệt về UI sử dụng Navigation compose + WindowSizeClass 

- Sử dụng NavController để handle back stack trong nested navigation

```kotlin
implementation("androidx.navigation:navigation-compose:{latest-version}")
```

Step 3: Handle layout with List-Detail composable support by Material3 composable

- [ListDetailPaneScaffold](https://developer.android.com/develop/ui/compose/layouts/adaptive/list-detail)

Step 4: State management và App continually 

## App Architecture 

![image](https://github.com/user-attachments/assets/d97c34b1-ccb6-423a-b18f-98d00052a368)

- UI layer: The role of the UI layer, or presentation layer, is to display the application data on the screen. Whenever the data changes due to a user interaction, such as pressing a button, the UI should update to reflect the changes.
The UI layer is made up of the following components:

  - UI elements: components that render the data on the screen. You build these elements using Jetpack Compose.
  - State holders: components that hold the data, expose it to the UI, and handle the app logic. An example state holder is ViewModel.

- ViewModel: component holds and exposes the state the UI consumes.

- UI State:
The UI is what the user sees, and the UI state is what the app says they should see. The UI is the visual representation of the UI state. Any changes to the UI state immediately are reflected in the UI.


![image](https://github.com/user-attachments/assets/2ed52356-3636-4b51-bae0-5668fc304639)





## Conclusion

By completing the exercise, you have demonstrated your ability to configure and utilize the Adaptive layout on Large Screens in Jetpack Compose. 


