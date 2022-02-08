package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        val tasks = emptyList<Task>()

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(0F))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        val tasks = null

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(0F))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 0F)
        assertEquals(result.activeTasksPercent, 100F)

        assertThat(result.completedTasksPercent, `is`(0F))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(100F))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title1", "desc", isCompleted = true),
            Task("title2", "desc", isCompleted = true),
            Task("title2", "desc", isCompleted = false),
            Task("title2", "desc", isCompleted = false),
            Task("title2", "desc", isCompleted = false),
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(40F))
        assertThat(result.activeTasksPercent, `is`(60f))
    }
}