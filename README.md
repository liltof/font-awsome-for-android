font-awsome-for-android DEPRECATED, NO LONGER MAINTAINED
=======================

Font awesome for android. Icons are from an OLD version of font awesome, and will no longer be maintained, but this can be a good example if you want to add font awesome icons to your app 

This is just a file that contains all font codes from font awesome, converted into an android string xml
Here seems to be a good fork, where you can generate a the xml from new versions of fontawesome (I didn't test it)
https://github.com/aasdkl/font-awsome-for-android
HOW TO :
========
Download the font-awesome.zip from fontawesome-webfont.ttf from http://fortawesome.github.io/Font-Awesome/

Extract it and put the fontawesome-webfont.ttf situated in font/ into the assets directory of your android project
Just replace the string.xml file in the values directory of your android project by this string.xml (or edit the content if you already have things in your strings.xml)

You're ready!

To use it :

    In a layout file :
	<TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/icon_credit_card"
        android:textSize="50sp"
        android:textColor="#F59012"
        android:textAppearance="?android:attr/textAppearanceLarge" />
    Or in a class :
    
    myTextView.setText(getString(R.string.icon_credit_card));
    
    
    
    Then in your class :

  	TextView txt = (TextView) findViewById(R.id.textView1);  
		Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
		txt.setTypeface(font);
    
