/*
 * Copyright (c) 2021, Dave Cramer
 * See the LICENSE file in the project root for more information.
 */

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
