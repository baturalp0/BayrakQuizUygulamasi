package com.example.bayrakquizuygulamas

import android.annotation.SuppressLint

class Bayraklardao {

    @SuppressLint("Range")
    fun rasgele5BayrakGetir(vt:VeritabaniYardimcisi) : ArrayList<Bayraklar> {

        val bayraklarListe = ArrayList<Bayraklar>()

        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null) //BU SORGUNUN SONUCU C YE AKTARILILR

        while (c.moveToNext()){
            val bayrak = Bayraklar(c.getInt(c.getColumnIndex("bayrak_id"))
                ,c.getString(c.getColumnIndex("bayrak_ad"))
                ,c.getString(c.getColumnIndex("bayrak_resim")))
            bayraklarListe.add(bayrak)
        }

        return bayraklarListe
    }


    @SuppressLint("Range")
    fun rasgele3YanlisSecenekGetir(vt:VeritabaniYardimcisi, bayrak_id:Int) : ArrayList<Bayraklar> {

        val bayraklarListe = ArrayList<Bayraklar>()

        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",null) //BU SORGUNUN SONUCU C YE AKTARILILR

        while (c.moveToNext()){
            val bayrak = Bayraklar(c.getInt(c.getColumnIndex("bayrak_id"))
                ,c.getString(c.getColumnIndex("bayrak_ad"))
                ,c.getString(c.getColumnIndex("bayrak_resim")))
            bayraklarListe.add(bayrak)
        }

        return bayraklarListe
    }



}