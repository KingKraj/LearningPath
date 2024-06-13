Ext.require([
  "Ext.application",
  "Ext.grid.Panel",
  "Ext.data.Model",
  "Ext.data.Store",
  "Ext.data.proxy.Ajax",
  "Ext.form.field.Number",
  "Ext.form.field.Text",
]);
Ext.application({
  name: "MyApp",

  launch: function () {
    // Define a model
    Ext.define("User", {
      extend: "Ext.data.Model",
      fields: [{ name: "name", type: "string" }],
    });

    // Create a store with a proxy to fetch data
    var userStore = Ext.create("Ext.data.Store", {
      model: "User",
      groupField: "name",
      proxy: {
        type: "ajax",
        url: "https://my-json-server.typicode.com/typicode/demo/profile", // Replace with your data source URL
        // reader: {
        //   type: "json",
        //   rootProperty: "data",
        // },
      },
      autoLoad: true, // Automatically load data when the store is created listeners: {
      //   beforeload: function (store, operation) {
      //     // Modify the raw data before it is loaded into the store
      //     console.log(" inside BeforeLoad =============>", operation);
      //     var rawData = operation.getResponse().responseText;
      //     var modifiedData = modifyRawData(JSON.parse(rawData));
      //     operation.setResponse(
      //       new Ext.data.Response({
      //         responseText: JSON.stringify(modifiedData),
      //         status: 200,
      //       })
      //     );
      //   },
    });
    var sourceData = userStore.getData().items.map(function (record) {
      console.log("Record ===============>", record);
      return record.data;
    });

    var destinationStore = Ext.create("Ext.data.Store", {
      model: userStore.getModel(),
      data: userStore,
    });
    destinationStore.on(
      "load",
      function (store, records, success, operation, eOpts) {
        if (success) {
          // Access raw data using the operation
          var rawData = operation.getResponse().responseText;
          console.log(" inside operation =============>", operation);

          // You can also decode the raw data if it's in JSON format
          // var decodedData = Ext.decode(rawData);
          // console.log(decodedData);
          var modifiedData = modifyRawData(JSON.parse(rawData));
          // operation.setRawResponse(JSON.stringify(modifiedData));
          // operation.response.responseText =JSON.stringify(modifiedData)
          // operation.setResponse(JSON.stringify(modifiedData));
          store.each(function (record) {
            modifyRecord(record);
          });
          var newRecord = Ext.create("User", {
            name: "New User",
            some: "some added value",
          });
          store.add(newRecord);
          // store.setResponse({
          //   responseText: JSON.stringify(modifiedData),
          //   status: 200,
          // });
          console.log(" After Modified >>>>>>>>>>>>>>>>>> ", destinationStore);
        } else {
          console.error("Failed to load data.");
        }
      }
    );
    // Create a grid to display the data
    console.log(
      " Before Load to Grid Panel >>>>>>>>>>>>>>>>>> ",
      destinationStore
    );
    var grid = Ext.create("Ext.grid.Panel", {
      title: "User Grid",
      store: destinationStore,
      features: [{ ftype: "grouping", groupHeaderTpl: ["Name: {some}"] }],
      columns: [
        { id: "nameId", text: "Name", dataIndex: "name" },
        { id: "someId", text: "Some", dataIndex: "some" },
      ],
      height: 300,
      width: 500,
      renderTo: Ext.getBody(),
    });
  },
});
function modifyRawData(data) {
  // Your modification logic here
  // For example, add a new property to each record
  // data.forEach(function (record) {
  console.log("just Prining:", data.name);
  data.name = "Modified Value";
  console.log(" After Modified =============>", data);
  // });
  return data;
}

function modifyRecord(record) {
  // Your modification logic here
  // For example, modify the 'name' field
  console.log(" Record =============>", record);
  record.set("name", "Modified Value");
  record.set("some", "Some Added Value");
}
