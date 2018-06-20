**MuViApp**

This application is developed using **MVP-VIPER architecture (Clean architecture)**

**Features of this application:**
    
    1. Display user profile and user location
    2. Allows login
    3. Allows registration
    4. Displays category listing for a logged in user
    5. Displays the list of collections under a category
    
**How to install:**

    1. Download latest android studio version
    2. Clone this project
    3. Sync the project
    4. Build the application and run it on a device
    5. The output will be in the folder "app/build/output/apk/app-debug.apk"
    
**Libraries used:**   

    1. Retrofit for network calls
    2. Glide - to display video thumbnail
    3. RxJava - For api response manipulations
    4. Dagger2 - for dependency injections
    5. Android Support libraries
    6. IconicsTextView - icon font text views
    
**Things that can be improved:**

    1. Api calls that have errors do not respond with the same kind of object types 
       - this would eliminate the use of checking the error message and doing stuff based on it
    2. Can add support for landscape mode
    3. We can define whether the accessToken is valid or not based on its live value
     