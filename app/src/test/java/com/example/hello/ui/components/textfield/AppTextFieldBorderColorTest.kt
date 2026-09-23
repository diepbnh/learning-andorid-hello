package com.example.hello.ui.components.textfield

import com.example.hello.ui.theme.LightAppColors
import org.junit.Assert.assertEquals
import org.junit.Test

class AppTextFieldBorderColorTest {

    @Test
    fun `defaults to the light color`() {
        assertEquals(
            LightAppColors.light,
            appTextFieldBorderColor(isError = false, isFocused = false, colors = LightAppColors)
        )
    }

    @Test
    fun `uses the danger color when in an error state`() {
        assertEquals(
            LightAppColors.danger,
            appTextFieldBorderColor(isError = true, isFocused = false, colors = LightAppColors)
        )
    }

    @Test
    fun `uses the primary color when focused`() {
        assertEquals(
            LightAppColors.primary,
            appTextFieldBorderColor(isError = false, isFocused = true, colors = LightAppColors)
        )
    }

    @Test
    fun `error takes precedence over focus`() {
        assertEquals(
            LightAppColors.danger,
            appTextFieldBorderColor(isError = true, isFocused = true, colors = LightAppColors)
        )
    }
}
