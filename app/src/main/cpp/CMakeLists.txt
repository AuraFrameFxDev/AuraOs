cmake_minimum_required(VERSION 3.18.1)

# Project configuration
project("auraframefx-native")

# Find required packages
find_library(log-lib log)
find_library(android-lib android)

# Set C++ standard
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Add the native library
add_library(
        auraframefx-native
        SHARED
        native-lib.cpp
)

# Include directories
target_include_directories(auraframefx-native PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}
)

# Link libraries
target_link_libraries(
        auraframefx-native
        ${log-lib}
        ${android-lib}
)

# Compiler-specific options
target_compile_options(auraframefx-native PRIVATE
        -Wall
        -Wno-unused-parameter
        -Wno-unused-function
)
