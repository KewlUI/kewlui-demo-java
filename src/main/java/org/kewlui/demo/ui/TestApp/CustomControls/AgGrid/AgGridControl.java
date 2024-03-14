package org.kewlui.demo.ui.TestApp.CustomControls.AgGrid;

import com.gofintec.kewlui.base.StateData;
import com.gofintec.kewlui.controls.base.VisualControl;
import com.gofintec.kewlui.controls.base.custom.ControlInfo;
import com.gofintec.kewlui.controls.base.custom.CustomControl;

import java.util.List;

////////////
// This control wraps AgGrid
// It will use remote include files
public class AgGridControl extends CustomControl {


    public AgGridControl (StateData state) {
        super(state);
        setDefaults(state);
    }
    public static AgGridControl appendTo(VisualControl parent, StateData state, Object... modifiers) {
        return appendTo(new AgGridControl(state), parent, state, modifiers);
    }

    protected void setDefaults(StateData state) {
        // set up some defaults
        this.setColumnDefs(state, List.of());
        this.setRowData(state, List.of());
        this.setDefaultColDef(state, new DefaultColDef(true, true, true, true));
        this.setRowSelection(state, RowSelection.single);
        List<AgGridControl.ToolPanel> toolPanels = List.of(new AgGridControl.ToolPanel("filters", "Filters", "filters", "filter", "agFiltersToolPanel"));
        //this.setSideBar(state,  new SideBar(toolPanels, "filters"));
        this.setDomLayout(state, "autoHeight");
        this.setAnimateRows(state, true);
        this.setClassName(state, "ag-theme-alpine");
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////

    public static record ColumnDef(String field, Boolean sortable, Boolean filter, String valueFormatter, String cellRenderer) {}

    public static record DefaultColDef(Boolean sortable, Boolean filter, Boolean floatingFilter, Boolean resizable) {}

    public enum RowSelection {
        single, multiple
    }

    public static record SideBar(List<AgGridControl.ToolPanel> toolPanels, String defaultToolPanel) {}

    public static record ToolPanel(String id, String labelDefault, String labelKey, String iconKey, String toolPanel) {}




    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Sets the column definitions
    public void setColumnDefs(StateData state, List<ColumnDef> value) {
        setProperty(state, "columnDefs", value);
    }

    // Retrieves the column definitions
    @SuppressWarnings("unchecked")
    public List<ColumnDef> getColumnDefs(StateData state) {
        return (List<ColumnDef>) getProperty(state, "columnDefs");
    }

    // Sets the default column definitions
    public void setDefaultColDef(StateData state, DefaultColDef value) {
        setProperty(state, "defaultColDef", value);
    }

    // Retrieves the default column definitions
    public DefaultColDef getDefaultColDef(StateData state) {
        return (DefaultColDef) getProperty(state, "defaultColDef");
    }

    // Sets the row selection configuration
    public void setRowSelection(StateData state, RowSelection value) {
        setProperty(state, "rowSelection", value);
    }

    // Retrieves the row selection configuration
    public RowSelection getRowSelection(StateData state) {
        return (RowSelection) getProperty(state, "rowSelection");
    }

    public void setRowData(StateData state, Object value) {
        setProperty(state, "rowData", value);
    }

    public Object getRowData(StateData state) {
        return getProperty(state, "rowData");
    }


    // Sets the sidebar configuration
    public void setSideBar(StateData state, SideBar value) {
        setProperty(state, "sideBar", value);
    }

    // Retrieves the sidebar configuration
    public SideBar getSideBar(StateData state) {
        return (SideBar) getProperty(state, "sideBar");
    }

    // Sets the DOM layout configuration
    public void setDomLayout(StateData state, String value) {
        setProperty(state, "domLayout", value);
    }

    // Retrieves the DOM layout configuration
    public String getDomLayout(StateData state) {
        return (String) getProperty(state, "domLayout");
    }

    // Sets the animate rows flag
    public void setAnimateRows(StateData state, boolean value) {
        setProperty(state, "animateRows", value);
    }

    // Retrieves the animate rows flag
    public boolean getAnimateRows(StateData state) {
        return (Boolean) getProperty(state, "animateRows");
    }

    public void setClassName(StateData state, String value) {
        setProperty(state, "className", value);
    }

    // Retrieves the animate rows flag
    public String getClassName(StateData state) {
        return (String) getProperty(state, "className");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static ControlInfo getControlInfo() {
        var controlInfo = ControlInfo.create();

        controlInfo.setInitJs("""                  
                  const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors, state} = params;
                  const element = document.getElementById(targetId);
                  if(element) {
                    var ex ={};
                    params.props.rowData = value ?? [];
                    params.state = null;
                    var xprops = {...props};
                    xprops.rowData = value ?? [];
                    
                    const grid = agGrid.createGrid(element, xprops);                    
                    for (const [key, value] of Object.entries(props)) {
                        delete xprops[key];
                    }
                    params.state = xprops;
                    params.state.grid = grid;
                  }
                """);
        controlInfo.setJavascript("""
                const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors, state} = params;
                let grid = state.grid;                
                if (grid) {   
                    grid.updateGridOptions( rowData, value ?? [] );
                }
                """);
        controlInfo.setDestroyJs("""
                const {targetId, props, eventHandlers, text, value, setValue, isSmallScreen, rebuild, colors, state} = params;                
                if (state.grid) {
                  state.grid.destroy();
                  state.grid = null;
                }
        """);

        controlInfo.setCss("""
              
                """);


        var includes = controlInfo.getIncludes();
        includes.put("AGGRID", "https://cdnjs.cloudflare.com/ajax/libs/ag-grid/31.2.0/ag-grid-community.min.js");
        includes.put("AGGRID_CSS2", "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/ag-grid-community@31.2.0/styles/ag-theme-alpine.css\" />");
        includes.put("AGGRID_CSS", "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/ag-grid-community@31.2.0/styles/ag-grid.css\" />");
        //includes.put("AGGRID", "https://cdnjs.cloudflare.com/ajax/libs/ag-grid/31.2.0/ag-grid-community.min.noStyle.js");
        //includes.put("AGGRID", "https://cdn.jsdelivr.net/npm/ag-grid-community/dist/ag-grid-community.min.js");

        controlInfo.setIncludes(includes);

        return controlInfo;
    }


}
