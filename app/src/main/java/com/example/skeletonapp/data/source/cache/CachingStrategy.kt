package com.example.skeletonapp.data.source.cache

sealed class CachingStrategy {
    object Local : CachingStrategy()
    object Memory : CachingStrategy()
}