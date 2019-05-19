# Android Kotlin Coroutines

## Motivation

This project aims to use the [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) of Kotlin.

The language used is [Kotlin](https://kotlinlang.org/).

For the dependency injection, it uses [Koin](https://github.com/InsertKoinIO/koin).

For the backend access, it uses [Retrofit](https://square.github.io/retrofit/).

To manage the app flow, it uses the [Navigation](https://developer.android.com/guide/navigation) component.

To test the application, it uses [MockK](https://github.com/mockk/mockk).

## Architecture

It uses three layers separated in three modules; `app`, `domain` and `data`. For the `ui` it uses the `MVVM` model.
The `app` and `data` modules are Android Modules, and the `domain` module is a Java Module.
All is communicated through contracts.

- The `app` module contains the `Views` and the `ViewModels`.
- The `domain` module contains the `Use Cases`.
- The `data` module contains the `Repositories` together with the `DataSources` and the `APIs`.

## What it does?

It uses [JSONPlaceHolder](https://jsonplaceholder.typicode.com/) as a backend to retrieve a list of users.
When a user in the list is clicked, it goes to a detail view of that user.

## Calls used

```kolin
https://jsonplaceholder.typicode.com/users

https://jsonplaceholder.typicode.com/users/{{user_id}}
```

## Tests

Tests can be found for the `app` and `data` modules.

## License
    Copyright 2019 Esteban Latre

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.