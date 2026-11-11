package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Context
import android.content.Intent

class ProcessingThread(private val context: Context) : Thread() {
    private var isRunning = true

    override fun run() {
        while (isRunning) {
            var num1 = (0..100).random()
            var num2 = (0..100).random()
            var num3 = (0..100).random()
            var num4 = (0..100).random()


            val intent = Intent()
            intent.action = "ro.pub.cs.systems.eim.action"
            intent.putExtra("nr1", num1)
            intent.putExtra("nr2", num2)
            intent.putExtra("nr3", num3)
            intent.putExtra("nr4", num4)
            context.sendBroadcast(intent)

            try {
                sleep(10000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    fun stopThread() {
        isRunning = false
    }
}