package com.kisel.boa.parser.ast;

import com.kisel.boa.lib.Value;

/**
 *
 * @author Kisel13
 */
public interface Expression extends Node {
    
    Value eval();
}
