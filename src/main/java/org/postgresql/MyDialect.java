/*
 * Copyright (c) 2021, Dave Cramer
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql;

import org.hibernate.dialect.PostgreSQL10Dialect;

import java.sql.Types;

public class MyDialect extends PostgreSQL10Dialect {
    public MyDialect() {
        this.registerColumnType(Types.BLOB, "lo");
    }
}
