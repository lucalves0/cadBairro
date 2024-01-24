package br.com.dgs.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.dgs.db.DB;
import br.com.dgs.interfaces.IPadraoRepository;
import br.com.dgs.model.Bairro;
import br.com.dgs.utils.Funcoes;

/*
public stclass BairroRepository implements IPadraoRepository {
    private static final String[] FLD_BAIRRO = {"id", "nome", "uf"};
    public SQLiteDatabase db;
    public static BairroRepository instance = new BairroRepository();

    public static BairroRepository getInstance(Context context){
        if(instance.db == null || instance.db.isOpen()){
            instance.db = new DB(context).getWritableDatabase();
        }
        return instance;
    }

    public void inserir(Object o){
        Bairro bairro = (Bairro)o;
        long codigo = -1;
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            if (bairro.getId().equals("")){
                cv.put("id", Funcoes.getUUID());
            }
            cv.put("nome", bairro.getNome());
            cv.put("uf", bairro.getUf());
            codigo = db.insert(DB.TBL_BAIRRO, null, cv);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
*/
