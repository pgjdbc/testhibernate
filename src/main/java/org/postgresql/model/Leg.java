package org.postgresql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;

@Entity
public class Leg {
    @Id
    int id;
    @Lob
    Blob csv_file;
}
