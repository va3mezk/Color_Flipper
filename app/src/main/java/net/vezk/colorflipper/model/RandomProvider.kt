package net.vezk.colorflipper.model

//HEX RANDOM COLORS
class RandomProvider {
    companion object {
        fun randomColor(): hexColor {
            val color=hexColor(randomNumber(),randomNumber(),randomNumber(),"")
            color.apply {
                hex = String.format("#%02X%02X%02X", red, green, blue)
            }
            return color
        }
        private fun randomNumber(): Int = (0..255).random()
    }
}