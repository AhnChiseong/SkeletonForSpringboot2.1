<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="Author" content="Fu:z" />
	<tiles:insertAttribute name="header" />
</head>
<body>
	<div id="gnb"><tiles:insertAttribute name="gnb" /></div>
	<div id="menu"><tiles:insertAttribute name="menu" /></div>
	<div id="content"><tiles:insertAttribute name="content" /></div>
	<div id="footer"><tiles:insertAttribute name="footer" /></div>
	<div id="script"><tiles:insertAttribute name="script" /></div>
</body>
</html>