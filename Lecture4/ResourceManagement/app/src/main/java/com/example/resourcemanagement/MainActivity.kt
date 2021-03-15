package com.example.resourcemanagement

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView;
    private var images: IntArray = intArrayOf(
            R.drawable.pexels_photo,
            R.drawable.pexels_photo_210723,
            R.drawable.pexels_photo_462353,
            R.drawable.pexels_photo_62592)
    private var imageList = ArrayList<Bitmap>();
    private var imageIndex : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val options = BitmapFactory.Options();
        options.inScaled = true;
        imageList.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo));
        imageList.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo_210723));
        imageList.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo_462353));
        imageList.add(BitmapFactory.decodeResource(resources, R.drawable.pexels_photo_62592));


        window.setTitle(resources.getText(R.string.app_name));
        setContentView(R.layout.activity_main);


        imageView = findViewById<ImageView>(R.id.imageView);
        imageView.setImageBitmap(imageList[imageIndex]);

        val nextButton: Button = findViewById(R.id.buttonNext)
        val previousButton: Button = findViewById(R.id.buttonPrevious)
        createOnClickListeners(nextButton, previousButton);

    }

    private fun createOnClickListeners(nextButton: Button, previousButton: Button){
        nextButton.setOnClickListener{
            nextImage()
        }

        previousButton.setOnClickListener{
            previousImage()
        }
    }

    private fun nextImage(): Boolean {
        if(findViewById<Button>(R.id.buttonNext).isPressed && imageIndex < images.size-1){
            imageIndex ++;
            imageView.setImageResource(images[imageIndex]);
            return true;
        }
        return false;

    }

    private fun previousImage(): Boolean{
        if(findViewById<Button>(R.id.buttonPrevious).isPressed && imageIndex > 0){
            imageIndex--;
            imageView.setImageResource(images[imageIndex])
            return true;
        }
        return false;
    }
}