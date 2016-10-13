package com.smk.funny.database.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smk.funny.database.DatabaseManager;
import com.smk.funny.database.OnDelete;
import com.smk.funny.database.OnSave;
import com.smk.funny.database.OnSelect;
import com.smk.funny.database.OnUpdate;
import com.smk.funny.database.models.Lang;

import java.util.ArrayList;
import java.util.List;

/**
 * DEVELOP BY SMK
 * YOU DON'T FORGET TO CHANGE DATABASE NAME IN THE DATABASE MANAGER CLASS;
 */

public class LangController extends DatabaseManager<Lang> {

	//To define table name;
	private static final String TABLE = "tbl_lang";
	//To define field name array;
	private static final String[] FIELD = { "id", "name", "translateText", "translatedText" };

	public LangController(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
		// To define listener for save, select, update, delete;
		setOnSave(onSaveRecords);
		setOnSelect(onSelectRecords);
		setOnUpate(onUpdateRecords);
		setOnDelete(onDeleteRecords);
	}

	@Override
	protected void createTables() {
		// TODO Auto-generated method stub
		// To define SQL command for table create;
		connectSQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS  "
				+ TABLE 	+ " ("
				+ FIELD[0] + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ FIELD[1] + " TEXT NULL,"
				+ FIELD[2] + " TEXT NULL,"
				+ FIELD[3] + " TEXT NULL)");
	}

	private OnSave<Lang> onSaveRecords = new OnSave<Lang>() {

		public void saveRecord(Lang value) {
			// TODO Auto-generated method stub
			// To define here for save to Lang;
			// ---------------------------------
			SQLiteDatabase db = getWritableDatabase();
			db.beginTransaction();
			try {
				/**
				 * YOU DON'T FORGET UNCOMMENT VALUE PUT METHODS "REMOVE //"
				 */
				ContentValues values = new ContentValues();
				values.put(FIELD[1], value.getName());
				values.put(FIELD[2], value.getTranslateText().toLowerCase().replace(" ","+"));
				values.put(FIELD[3], value.getTranslatedText());

				db.insert(TABLE, null, values);
				db.setTransactionSuccessful();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.endTransaction();
				db.close();
			}
		}

		public void saveRecord(List<Lang> value) {
			// TODO Auto-generated method stub
			// To define here for save to list;
			// --------------------------------------
		}
	};

	private OnSelect<Lang> onSelectRecords = new OnSelect<Lang>() {

		public Lang find(String arg0, String arg1) {
			// TODO Auto-generated method stub
			// To define here for select Lang by String arg0;
			// Maybe as Lang id;
			// --------------------------------------
			Lang lang = null;
			try {

				String[] VALUE = { arg0.toString(), arg1.toLowerCase().replace(" ","+") };
				String WHERE = FIELD[1] + "=? and "+ FIELD[2] + "=? ";
				String ORDER_BY = FIELD[0] + " ASC";

				SQLiteDatabase db = getReadableDatabase();
				Cursor cursor = db.query(TABLE, FIELD, WHERE, VALUE, null,null, ORDER_BY);
				try {
					if (cursor.moveToFirst()) {
						do {
							lang = new Lang();
							lang.setName(cursor.getString(1));
							lang.setTranslateText(cursor.getString(2));
							lang.setTranslatedText(cursor.getString(3));

						} while (cursor.moveToNext());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					cursor.close();
					db.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return lang;
		}

		public Lang selectRecord(Integer arg0) {
			// TODO Auto-generated method stub
			// To define here for select Lang by String arg0;
			// Maybe as Lang id;
			// --------------------------------------
			Lang lang = null;
			try {

				String[] VALUE = { arg0.toString() };
				String WHERE = FIELD[0] + "=? ";
				String ORDER_BY = FIELD[0] + " ASC";

				SQLiteDatabase db = getReadableDatabase();
				Cursor cursor = db.query(TABLE, FIELD, WHERE, VALUE, null,null, ORDER_BY);
				try {
					if (cursor.moveToFirst()) {
						do {
							lang = new Lang();
							lang.setName(cursor.getString(1));
							lang.setTranslateText(cursor.getString(2));
							lang.setTranslatedText(cursor.getString(3));

						} while (cursor.moveToNext());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					cursor.close();
					db.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return lang;
		}

		public List<Lang> selectRecords() {
			// TODO Auto-generated method stub
			// To define here for select all Lang;
			// --------------------------------------
			List<Lang> list = new ArrayList<Lang>();
			try {

				String ORDER_BY = FIELD[0] + " ASC";

				SQLiteDatabase db = getReadableDatabase();
				Cursor cursor = db.query(TABLE, FIELD, null, null, null,null, ORDER_BY);
				try {
					if (cursor.moveToFirst()) {
						do {
							Lang lang = new Lang();
							lang.setName(cursor.getString(1));
							lang.setTranslateText(cursor.getString(2));
							lang.setTranslatedText(cursor.getString(3));
							list.add(lang);
						} while (cursor.moveToNext());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					cursor.close();
					db.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return list;
		}

		public List<Lang> selectRecords(String arg0) {
			// TODO Auto-generated method stub
			// To define here for select Lang list by String arg0;
			// Maybe as Lang name;
			// --------------------------------------
			List<Lang> list = new ArrayList<Lang>();
			try {

				String[] VALUE = { arg0, arg0 };
				String WHERE = FIELD[1] + "=? or "+FIELD[2] + "=? ";
				String ORDER_BY = FIELD[0] + " ASC";

				SQLiteDatabase db = getReadableDatabase();
				Cursor cursor = db.query(TABLE, FIELD, WHERE, VALUE, null,null, ORDER_BY);
				try {
					if (cursor.moveToFirst()) {
						do {
							Lang lang = new Lang();
							lang.setName(cursor.getString(1));
							lang.setTranslateText(cursor.getString(2));
							lang.setTranslatedText(cursor.getString(3));
							list.add(lang);
						} while (cursor.moveToNext());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					cursor.close();
					db.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return list;
		}

		public List<Lang> selectRecords(Lang value) {
			// TODO Auto-generated method stub
			// To define here for select Lang list by String arg0;
			// Maybe as multiple Lang name;
			// --------------------------------------

			return null;
		}
	};

	private OnUpdate<Lang> onUpdateRecords = new OnUpdate<Lang>() {

		public void updateRecord(Lang lang) {
			// TODO Auto-generated method stub
			// To define here for update an Lang;
			// --------------------------------------
			SQLiteDatabase db = getWritableDatabase();
			db.beginTransaction();
			try {
				/**
				 * YOU DON'T FORGET UNCOMMENT VALUE PUT METHODS "REMOVE //"
				 */
				ContentValues values = new ContentValues();
				values.put(FIELD[1], lang.getName());
				values.put(FIELD[2], lang.getTranslateText());
				values.put(FIELD[3], lang.getTranslatedText());

				db.update(TABLE, values, FIELD[2]+"=? ", new String[]{lang.getTranslateText().toString()});
				db.setTransactionSuccessful();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.endTransaction();
				db.close();
			}
		}

		public void updateReourd(List<Lang> value) {
			// TODO Auto-generated method stub
			// To define here for update the Lang list;
			// --------------------------------------
		}
	};

	private OnDelete onDeleteRecords = new OnDelete() {

		public void deleteRecord(String arg0) {
			// TODO Auto-generated method stub
			// To define here for delete an Lang by id or Lang's field;
			// --------------------------------------
			SQLiteDatabase db = getWritableDatabase();
			db.delete(TABLE, FIELD[0]+"=? ", new String[]{ arg0 });
			db.close();
		}

		public void deleteRecord() {
			// TODO Auto-generated method stub
			// To define here for delete all Lang;
			// --------------------------------------
			SQLiteDatabase db = getWritableDatabase();
			db.delete(TABLE, null, null);
			db.close();
		}
	};
	/**
	 * return string id;
	 * format ##-00000001;
	 */
	@Override
	public String generateAutoId() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = null;
		Integer LangId = 1;
		try {
			String ORDER_BY = FIELD[0] + " DESC LIMIT 1";
			cursor  = db.query(TABLE, FIELD, null, null, null,null, ORDER_BY);
			if (cursor.moveToFirst()) {
				do {
					LangId = cursor.getInt(0);
					LangId = Integer.valueOf(LangId) + 1;
				} while (cursor.moveToNext());
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			cursor.close();
			db.close();
		}
		return LangId.toString();
	}

}
