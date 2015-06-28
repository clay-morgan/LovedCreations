<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
    /*
     For a working file input dialog with the bootstrap styles (1 of 2)
     custom file input component from http://www.surrealcms.com/blog/whipping-file-inputs-into-shape-with-bootstrap-3
     */
    $(document).on('change', '.btn-file :file', function() {
        var input = $(this),
                numFiles = input.get(0).files ? input.get(0).files.length : 1,
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
        input.trigger('fileselect', [numFiles, label]);
    });

    /*
     For a working file input dialog with the bootstrap styles (2 of 2)
     custom file input component from http://www.surrealcms.com/blog/whipping-file-inputs-into-shape-with-bootstrap-3
     */
    $(document).ready( function() {
        $('.btn-file :file').on('fileselect', function(event, numFiles, label) {

            var input = $(this).parents('.input-group').find(':text'),
                    log = numFiles > 1 ? numFiles + ' files selected' : label;

            if( input.length ) {
                input.val(log);
            } else {
                if( log ) alert(log);
            }

        });
    });
</script>

<div class="panel panel-info">
    <div class="panel-heading">
        <h1 class="panel-title">Upload an Image File</h1>
    </div>
    <div class="panel-body">
        <form action="${pageContext.request.contextPath}/addPhotoSubmit" method="post" class="form" role="form" enctype="multipart/form-data">
            <input type="hidden" name="creation" value="${creation}"/>
            <div class="input-group">
                <span class="input-group-btn">
                    <span class="btn btn-primary btn-file">
                        Browse <input type="file" class="btn btn-primary" name="file"/>
                    </span>
                </span>
                <input type="text" class="form-control" readonly="true"/>
            </div>
            <p class="top-padded pull-right">
                <input type="submit" class="btn btn-primary left-padded" value="Begin Upload"/>
            </p>
        </form>
        <ol class="top-padded">
            <li>Click 'Browse' and find your image file</li>
            <li>Click 'Ok' to select the image file</li>
            <li>Click 'Begin Upload' to update the logo image</li>
        </ol>
        <a href="${pageContext.request.contextPath}/" class="btn btn-warning">Cancel</a>
    </div>
</div>
