
syntax = "proto3";

package ${packageName}.pbo;

<#list clazzinfos as clazzinfo >
message PB${clazzinfo.domainClass}
{
	<#list clazzinfo.columnInfos as colinfo> 
	${colinfo.pbtype} ${colinfo.pbfield} = ${colinfo_index+1};
	</#list>
}

</#list>