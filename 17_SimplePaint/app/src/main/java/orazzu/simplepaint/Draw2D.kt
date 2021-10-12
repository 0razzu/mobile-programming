package orazzu.simplepaint

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.View


class Draw2D(context: Context?): View(context) {
    private val paint: Paint = Paint()


    companion object {
        val BLUE = Color.rgb(30, 0, 255)
        val SKY_BLUE = Color.rgb(65, 170, 255)
        val YELLOW = Color.rgb(255, 210, 95)
        val GRASS_GREEN = Color.rgb(90, 160, 50)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.apply {
            style = Paint.Style.FILL
            color = Color.WHITE
        }
        canvas?.drawPaint(paint)

        paint.color = SKY_BLUE
        canvas?.drawRect(20F, 5F, 980F, 600F, paint)

        paint.apply {
            isAntiAlias = true
            color = YELLOW
        }
        canvas?.drawCircle(945F, 40F, 30F, paint)

        paint.color = GRASS_GREEN
        canvas?.drawRect(20F, 600F, 980F, 800F, paint)

        paint.apply {
            color = BLUE
            style = Paint.Style.FILL
            isAntiAlias = true
            textSize = 42F
        }
        canvas?.drawText("Лужайка только для котов", 30F, 580F, paint)

        paint.apply {
            color = YELLOW
            style = Paint.Style.FILL
            textSize = 27F
        }

        val rect: Rect = Rect()
        val x = 790F
        val y = 210F

        canvas?.save()
        canvas?.rotate(-45F, x + rect.exactCenterX(), y + rect.exactCenterY())
        canvas?.drawText("Лучик солнца!", x, y, paint)
        canvas?.restore()

        canvas?.drawBitmap(
            BitmapFactory.decodeResource(resources, R.drawable.cat),
            600F,
            420F,
            paint
        )
    }
}