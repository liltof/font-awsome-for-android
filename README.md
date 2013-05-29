font-awsome-for-android
=======================

Font awesome for android.

This is just a file that contains all font codes from font awesome, converted into an android string xml

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
    
