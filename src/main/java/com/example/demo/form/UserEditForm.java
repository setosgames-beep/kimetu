package com.example.demo.form;

import lombok.Data;

@Data
public class UserEditForm {
	/** ユーザーID */
    private long id;

    /** ユーザー名 */
    private String name;

    /** 自己紹介・自由記入欄 */
    private String body;

    /** 診断結果 */
    private String diagnosisResult;
}
